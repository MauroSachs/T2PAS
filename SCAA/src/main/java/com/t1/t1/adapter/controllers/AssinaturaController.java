package com.t1.t1.adapter.controllers;

import com.t1.t1.application.dtos.AssinaturaDTO;
import com.t1.t1.application.dtos.AssinaturaRequestDTO;
import com.t1.t1.application.dtos.AssinaturaTipoRequestDTO;
import com.t1.t1.application.usecases.aplicativo.AssinarAplicativoUseCase;
import com.t1.t1.application.usecases.assinaturas.ListarAssinaturasUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servcad/assinaturas")
public class AssinaturaController {

    final AssinarAplicativoUseCase assinarAplicativoUseCase;
    final ListarAssinaturasUseCase listarAssinaturasUseCase;

    public AssinaturaController(AssinarAplicativoUseCase assinarAplicativoUseCase, ListarAssinaturasUseCase listarAssinaturasUseCase) {
        this.assinarAplicativoUseCase = assinarAplicativoUseCase;
        this.listarAssinaturasUseCase = listarAssinaturasUseCase;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AssinaturaDTO> assinar(@RequestBody AssinaturaRequestDTO request) {
        try {
            AssinaturaDTO assinaturaDTO = assinarAplicativoUseCase.call(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(assinaturaDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AssinaturaDTO>> listarTodos() {
        try {
            List<AssinaturaDTO> assinaturas = listarAssinaturasUseCase.call(AssinaturaTipoRequestDTO.TODAS);
            return ResponseEntity.ok(assinaturas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "{tipo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AssinaturaDTO>> listarPorTipo(@PathVariable AssinaturaTipoRequestDTO tipo) {
        try {
            List<AssinaturaDTO> assinaturas = listarAssinaturasUseCase.call(tipo);
            return ResponseEntity.ok(assinaturas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

/*
lista de cada endpoint
POST /servcad/assinaturas - assinar
GET /servcad/assinaturas - listarTodos
GET /servcad/assinaturas/{tipo} - listarPorTipo

 */
