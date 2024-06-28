package com.t1.t1.application.dtos;

import com.t1.t1.domain.entities.ClienteEntity;

public class ClienteDTO {
    private long id;
    private String nome;
    private String email;

    public ClienteDTO() {
    }

    public ClienteDTO(ClienteEntity cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}