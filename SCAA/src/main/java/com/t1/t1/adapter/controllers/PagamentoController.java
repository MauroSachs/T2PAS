package com.t1.t1.adapter.controllers;

import com.t1.t1.application.dtos.PagamentoDTO;
import com.t1.t1.application.dtos.PagamentoRequestDTO;
import com.t1.t1.application.usecases.pagamento.RegistrarPagamentoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registrarpagamento")
public class PagamentoController {
    final RegistrarPagamentoUseCase registrarPagamentoUseCase;

    public PagamentoController(RegistrarPagamentoUseCase registrarPagamentoUseCase) {
        this.registrarPagamentoUseCase = registrarPagamentoUseCase;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagamentoDTO> create(@RequestBody PagamentoRequestDTO request) {
        try {
            PagamentoDTO pagamentoDTO = registrarPagamentoUseCase.call(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}


/*
POST /registrarpagamento - create
 */