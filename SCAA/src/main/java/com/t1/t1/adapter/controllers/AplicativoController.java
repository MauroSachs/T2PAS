package com.t1.t1.adapter.controllers;

import com.t1.t1.application.dtos.AplicativoDTO;
import com.t1.t1.application.dtos.AplicativoRequestDTO;
import com.t1.t1.application.usecases.aplicativo.AlterarAplicativoUseCase;
import com.t1.t1.application.usecases.aplicativo.AtualizarCustoUseCase;
import com.t1.t1.application.usecases.aplicativo.CadastrarAplicativoUseCase;
import com.t1.t1.application.usecases.aplicativo.ListarAplicativosUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servcad/aplicativos")
public class AplicativoController {

    private final CadastrarAplicativoUseCase cadastrarAplicativoUseCase;
    private final ListarAplicativosUseCase listarAplicativosUseCase;
    private final AlterarAplicativoUseCase alterarAplicativoUseCase;
    private final AtualizarCustoUseCase atualizarCustoUseCase;

    public AplicativoController(CadastrarAplicativoUseCase cadastrarAplicativoUseCase, ListarAplicativosUseCase listarAplicativosUseCase, AlterarAplicativoUseCase alterarAplicativoUseCase, AtualizarCustoUseCase atualizarCustoUseCase) {
        this.cadastrarAplicativoUseCase = cadastrarAplicativoUseCase;
        this.listarAplicativosUseCase = listarAplicativosUseCase;
        this.alterarAplicativoUseCase = alterarAplicativoUseCase;
        this.atualizarCustoUseCase = atualizarCustoUseCase;
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AplicativoDTO> create(@RequestBody AplicativoRequestDTO request) {
        try {
            AplicativoDTO aplicativoDTO = cadastrarAplicativoUseCase.call(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(aplicativoDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AplicativoDTO>> listarTodos() {
        try {
            List<AplicativoDTO> aplicativos = listarAplicativosUseCase.call();
            return ResponseEntity.ok(aplicativos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //get by id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AplicativoDTO> getById(@PathVariable Long id) {
        try {
            AplicativoDTO aplicativoDTO = listarAplicativosUseCase.buscaPorId(id);
            return ResponseEntity.ok(aplicativoDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping(value = "/atualizacusto/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AplicativoDTO> atualizaCusto(@PathVariable Long id, @RequestBody AplicativoRequestDTO request) {
        try {
            AplicativoDTO aplicativoDTO = atualizarCustoUseCase.call(id, request.custoMensal());
            return ResponseEntity.ok(aplicativoDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AplicativoDTO> alterar(@PathVariable Long id, @RequestBody AplicativoRequestDTO request) {
        try {
            AplicativoDTO aplicativoDTO = alterarAplicativoUseCase.call(id, request);
            return ResponseEntity.ok(aplicativoDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

