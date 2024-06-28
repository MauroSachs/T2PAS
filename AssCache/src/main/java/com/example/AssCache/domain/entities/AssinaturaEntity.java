package com.example.AssCache.domain.entities;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class AssinaturaEntity {

    private Long id;
    private LocalDate fimVigencia;

    public AssinaturaEntity() {
    }

    public AssinaturaEntity(Long id, LocalDate fimVigencia) {
        this.id = id;
        this.fimVigencia = fimVigencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(LocalDate fimVigencia) {
        this.fimVigencia = fimVigencia;
    }
}