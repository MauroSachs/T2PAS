package com.t1.t1.adapter.models;

import com.t1.t1.domain.entities.UsuarioEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String senha;

    public UsuarioModel() {
    }

    public UsuarioModel(UsuarioEntity usuario) {
    }

    public UsuarioEntity toEntity() {
        return new UsuarioEntity(this.id, this.usuario, this.senha);
    }
}
