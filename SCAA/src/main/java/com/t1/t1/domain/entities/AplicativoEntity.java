package com.t1.t1.domain.entities;

public class AplicativoEntity {

    private Long id;
    private String nome;
    private Double custoMensal;

    public AplicativoEntity() {
    }

    public AplicativoEntity(Long id, String nome, Double custoMensal) {
        this.id = id;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCustoMensal() {
        return custoMensal;
    }

    public void setCustoMensal(Double custoMensal) {
        this.custoMensal = custoMensal;
    }


}