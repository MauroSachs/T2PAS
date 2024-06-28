package com.t1.t1.application.usecases.pagamento;

import com.t1.t1.application.dtos.PagamentoDTO;
import com.t1.t1.application.dtos.PagamentoRequestDTO;
import com.t1.t1.domain.entities.AssinaturaEntity;
import com.t1.t1.domain.entities.PagamentoEntity;
import com.t1.t1.domain.exceptions.ValorIncorretoException;
import com.t1.t1.domain.services.AssinaturaService;
import com.t1.t1.domain.services.PagamentoService;

import static com.t1.t1.application.dtos.PagamentoStatusDTO.PAGAMENTO_OK;
import static com.t1.t1.application.dtos.PagamentoStatusDTO.VALOR_INCORRETO;

public class RegistrarPagamentoUseCase {
    
    final PagamentoService pagamentoService;

    final AssinaturaService assinaturaService;

    public RegistrarPagamentoUseCase(PagamentoService pagamentoService, AssinaturaService assinaturaService) {
        this.pagamentoService = pagamentoService;
        this.assinaturaService = assinaturaService;
    }

    public PagamentoDTO call(PagamentoRequestDTO pagamentoRequestDTO) {
        AssinaturaEntity assinatura = assinaturaService.getAssinatura(pagamentoRequestDTO.codAss());
        if (assinatura == null) {
            throw new RuntimeException("Assinatura não encontrada");
        }
        try {
            PagamentoEntity pagamento = pagamentoService.registrarPagamento(pagamentoRequestDTO.day(), assinatura, pagamentoRequestDTO.valorPago(), pagamentoRequestDTO.promocao());
            return new PagamentoDTO(pagamento.getId(), PAGAMENTO_OK, pagamento.getDataPagamento(), pagamento.getValorEstornado(), pagamento.getValorPago(), pagamento.getPromocao());
        } catch (ValorIncorretoException e) {
            return new PagamentoDTO(-1L, VALOR_INCORRETO, pagamentoRequestDTO.day(), 0.0, 0.0, "none");
        }
        
    }
    
}
