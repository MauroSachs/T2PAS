package com.t1.t1.adapter.controllers;

import com.t1.t1.application.dtos.AssinaturaDTO;
import com.t1.t1.application.usecases.assinaturas.ListarClientesAssinadosUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/servcad/assapp")
public class AssinaturaAplicativoController {

    final ListarClientesAssinadosUseCase listarClientesAssinadosUseCase;

    public AssinaturaAplicativoController(ListarClientesAssinadosUseCase listarClientesAssinadosUseCase) {
        this.listarClientesAssinadosUseCase = listarClientesAssinadosUseCase;
    }

    //listar todos os clientes assinados em um aplicativo
    @GetMapping(value = "/{idAplicativo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AssinaturaDTO>> listarClientesAssinados(@PathVariable Long idAplicativo) {
        try {
            List<AssinaturaDTO> assinaturas = listarClientesAssinadosUseCase.call(idAplicativo);
            return ResponseEntity.ok(assinaturas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

/*
lista de cada endpoint
1. POST /servcad/assapp/{idAplicativo} - listarClientesAssinados
 */