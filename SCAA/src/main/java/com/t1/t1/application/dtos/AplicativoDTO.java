package com.t1.t1.application.dtos;

import com.t1.t1.domain.entities.AplicativoEntity;

public class AplicativoDTO {
    private long id;
    private String nome;
    private Double custoMensal;

    public AplicativoDTO() {
    }

    public AplicativoDTO(AplicativoEntity aplicativo) {
        this.id = aplicativo.getId();
        this.nome = aplicativo.getNome();
        this.custoMensal = aplicativo.getCustoMensal();
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getCustoMensal() {
        return custoMensal;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCustoMensal(Double custoMensal) {
        this.custoMensal = custoMensal;
    }
}