package com.t1.t1.domain.entities;

import java.time.LocalDate;

public class PagamentoEntity {
    private Long id;
    private AssinaturaEntity assinatura;
    private LocalDate dataPagamento;
    private String promocao;
    private Double valorEstornado, valorPago;

    public PagamentoEntity() {
    }

    public PagamentoEntity(Long id, AssinaturaEntity assinatura, LocalDate dataPagamento, String promocao, Double valorEstornado, Double valorPago) {
        this.id = id;
        this.assinatura = assinatura;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
        this.valorEstornado = valorEstornado;
        this.valorPago = valorPago;
    }

    public Double getValorEstornado() {
        return valorEstornado;
    }

    public void setValorEstornado(Double valorEstornado) {
        this.valorEstornado = valorEstornado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AssinaturaEntity getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(AssinaturaEntity assinatura) {
        this.assinatura = assinatura;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getPromocao() {
        return promocao;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

}
