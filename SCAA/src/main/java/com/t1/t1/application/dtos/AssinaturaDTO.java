package com.t1.t1.application.dtos;

import com.t1.t1.domain.entities.AssinaturaEntity;

import java.time.LocalDate;

public class AssinaturaDTO {
    private Long id;
    private ClienteDTO cliente;
    private AplicativoDTO aplicativo;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;

    public AssinaturaDTO() {
    }

    public AssinaturaDTO(AssinaturaEntity assinatura, ClienteDTO cliente, AplicativoDTO aplicativo) {
        this.id = assinatura.getId();
        this.cliente = cliente;
        this.aplicativo = aplicativo;
        this.inicioVigencia = assinatura.getInicioVigencia();
        this.fimVigencia = assinatura.getFimVigencia();
    }


    public Long getId() {
        return id;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public AplicativoDTO getAplicativo() {
        return aplicativo;
    }

    public LocalDate getInicioVigencia() {
        return inicioVigencia;
    }


    public LocalDate getFimVigencia() {
        return fimVigencia;
    }

}

