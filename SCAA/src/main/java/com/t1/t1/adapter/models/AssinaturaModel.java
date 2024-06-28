package com.t1.t1.adapter.models;

import com.t1.t1.domain.entities.AssinaturaEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class AssinaturaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;

    @ManyToOne
    private AplicativoModel aplicativo;

    @ManyToOne
    private ClienteModel cliente;

    @OneToMany
    private List<PagamentoModel> pagamentos;


    public AssinaturaModel() {
    }

    public AssinaturaModel(AssinaturaEntity assinatura) {
        if (assinatura.getId() != null) {
            this.id = assinatura.getId();
        }

        this.inicioVigencia = assinatura.getInicioVigencia();
        this.fimVigencia = assinatura.getFimVigencia();

        if (assinatura.getAplicativo() != null) {
            this.aplicativo = new AplicativoModel(assinatura.getAplicativo());
        }

        if (assinatura.getCliente() != null) {
            this.cliente = new ClienteModel(assinatura.getCliente());
        }

    }

    public AssinaturaEntity toEntity() {
        return new AssinaturaEntity(id, inicioVigencia, fimVigencia, aplicativo.toEntity(), cliente.toEntity());
    }

    public List<PagamentoModel> getPagamentos() {
        if (pagamentos == null) {
            pagamentos = new ArrayList<>();
        }
        return pagamentos;
    }
}
