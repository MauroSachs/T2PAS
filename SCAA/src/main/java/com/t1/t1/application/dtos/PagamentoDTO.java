package com.t1.t1.application.dtos;
import java.time.LocalDate;

public class PagamentoDTO {
    private Long id;
    private PagamentoStatusDTO status;
    private LocalDate dataPagamento; 
    private Double valorEstornado, valorPago;
    private String promocao;

    public PagamentoDTO() {
    }

    public PagamentoDTO(Long id, PagamentoStatusDTO status, LocalDate dataPagamento, Double valorEstornado, Double valorPago, String promocao) {
        this.id = id;
        this.status = status;
        this.dataPagamento = dataPagamento;
        this.valorEstornado = valorEstornado;
        this.valorPago = valorPago;
        this.promocao = promocao;
    }

    public String getPromocao() {
        return promocao;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    public Long getId() {
        return id;
    }

    public PagamentoStatusDTO getStatus() {
        return status;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public Double getValorEstornado() {
        return valorEstornado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(PagamentoStatusDTO status) {
        this.status = status;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setValorEstornado(Double valorEstornado) {
        this.valorEstornado = valorEstornado;
    }

}