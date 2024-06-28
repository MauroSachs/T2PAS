package com.t1.t1.domain.services;

import com.t1.t1.domain.entities.AssinaturaEntity;
import com.t1.t1.domain.entities.PagamentoEntity;
import com.t1.t1.domain.exceptions.ValorIncorretoException;
import com.t1.t1.domain.repositories.AssinaturaRepository;
import com.t1.t1.domain.repositories.PagamentoRepository;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.time.LocalDate;

public class PagamentoService {

    final PagamentoRepository pagamentoRepository;
    final AssinaturaRepository assinaturaRepository;
    final RabbitTemplate rabbitTemplate;
    final FanoutExchange fanoutExchange;

    public PagamentoService(PagamentoRepository pagamentoRepository, AssinaturaRepository assinaturaRepository, RabbitTemplate rabbitTemplate, FanoutExchange fanoutExchange) {
        this.pagamentoRepository = pagamentoRepository;
        this.assinaturaRepository = assinaturaRepository;
        this.rabbitTemplate = rabbitTemplate;
        this.fanoutExchange = fanoutExchange;
    }

    public PagamentoEntity registrarPagamento(LocalDate day, AssinaturaEntity assinaturaEntity, double valorPago, String promocao) {

        if(!day.equals(LocalDate.now())) {
            throw new RuntimeException("Data de pagamento inválida");
        }

        Double valorAPagar = assinaturaEntity.getAplicativo().getCustoMensal();

        switch (promocao) {
            case "CUPOM15" -> valorAPagar = valorAPagar * 0.85;
            case "CUPOM25" -> valorAPagar = valorAPagar * 0.75;
            case "CUPOM50" -> valorAPagar = valorAPagar * 0.5;
        }

        if (valorPago < valorAPagar) {
            throw new ValorIncorretoException("Valor pago menor que o valor a ser pago");
        }

        Double estorno = valorPago - valorAPagar;

        valorPago = valorAPagar;

        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setAssinatura(assinaturaEntity);
        pagamentoEntity.setDataPagamento(day);
        pagamentoEntity.setValorPago(valorPago);
        pagamentoEntity.setPromocao(promocao);
        pagamentoEntity.setValorEstornado(estorno);
        pagamentoEntity = pagamentoRepository.save(pagamentoEntity);

        assinaturaEntity.getPagamentos().add(pagamentoEntity);

        if (assinaturaEntity.getFimVigencia().isBefore(LocalDate.now())) {
            assinaturaEntity.setInicioVigencia(LocalDate.now());
            assinaturaEntity.setFimVigencia(LocalDate.now().plusMonths(1));
        } else {
            assinaturaEntity.setFimVigencia(assinaturaEntity.getFimVigencia().plusMonths(1));
        }

        assinaturaRepository.save(assinaturaEntity);

        enviarMensagemAtualizacaoAssinatura(assinaturaEntity);

        return pagamentoEntity;
    }

    private void enviarMensagemAtualizacaoAssinatura(AssinaturaEntity assinaturaEntity) {
        //preciso enviar id e data de vencimento formato = id:dataVencimento
        String message = assinaturaEntity.getId() + ":" + assinaturaEntity.getFimVigencia();
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", message);

    }
}
