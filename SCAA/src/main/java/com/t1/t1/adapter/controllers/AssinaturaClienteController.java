package com.t1.t1.adapter.controllers;

import com.t1.t1.application.dtos.AssinaturaDTO;
import com.t1.t1.application.usecases.assinaturas.ListarAssinaturasDoClienteUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/servcad/asscli")
public class AssinaturaClienteController {

    final ListarAssinaturasDoClienteUseCase listarAssinaturasDoClienteUseCase;

    public AssinaturaClienteController(ListarAssinaturasDoClienteUseCase listarAssinaturasDoClienteUseCase) {
        this.listarAssinaturasDoClienteUseCase = listarAssinaturasDoClienteUseCase;
    }

    //listar todas assinaturas de um cliente
    @GetMapping(value = "/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AssinaturaDTO>> listarPorCliente(@PathVariable Long idCliente) {
        try {
            List<AssinaturaDTO> assinaturas = listarAssinaturasDoClienteUseCase.call(idCliente);
            return ResponseEntity.ok(assinaturas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

/*
lista de cada endpoint
GET /servcad/asscli/{idCliente} - listarPorCliente
 */