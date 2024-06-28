package com.t1.t1.adapter.models;

import com.t1.t1.domain.entities.AplicativoEntity;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class AplicativoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double custoMensal;

    public AplicativoModel() {
    }

    public AplicativoModel(AplicativoEntity aplicativo) {
        if (aplicativo.getId() != null) {
            this.id = aplicativo.getId();
        }
        this.nome = aplicativo.getNome();
        this.custoMensal = aplicativo.getCustoMensal();
    }

    public AplicativoEntity toEntity() {
        return new AplicativoEntity(this.id, this.nome, this.custoMensal);
    }

}
