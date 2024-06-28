package com.t1.t1.adapter.controllers;

import com.t1.t1.application.usecases.assinaturas.ValidarAssinaturaUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assinvalida")
public class AssinaturaValidaController {

    final ValidarAssinaturaUseCase validarAssinaturaUseCase;

    public AssinaturaValidaController(ValidarAssinaturaUseCase validarAssinaturaUseCase) {
        this.validarAssinaturaUseCase = validarAssinaturaUseCase;
    }

    //retorna se a assinatura é válida ou não
    @GetMapping(value = "/{idAssinatura}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> validarAssinatura(@PathVariable Long idAssinatura) {
        try {
            Boolean assinaturaValida = validarAssinaturaUseCase.call(idAssinatura);
            return ResponseEntity.ok(assinaturaValida);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
/*
GET /assinvalida/{idAssinatura} - validarAssinatura
 */