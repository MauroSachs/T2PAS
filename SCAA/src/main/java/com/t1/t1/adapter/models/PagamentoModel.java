package com.t1.t1.adapter.models;

import com.t1.t1.domain.entities.PagamentoEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class PagamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private AssinaturaModel assinatura;

    private Double valorEstornado, valorPago;
    private LocalDate dataPagamento;
    private String promocao;

    public PagamentoModel() {
    }

    public PagamentoModel(PagamentoEntity pagamentoEntity) {
        if (pagamentoEntity.getId() != null) {
            this.id = pagamentoEntity.getId();
        }

        this.dataPagamento = pagamentoEntity.getDataPagamento();
        this.promocao = pagamentoEntity.getPromocao();
        this.valorEstornado = pagamentoEntity.getValorEstornado();
        this.valorPago = pagamentoEntity.getValorPago();
    }

    public PagamentoEntity toEntity() {
        return new PagamentoEntity(this.id, this.assinatura.toEntity(), this.dataPagamento, this.promocao, this.valorEstornado, this.valorPago);
    }
}
