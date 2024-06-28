package com.t1.t1.adapter.controllers;

import com.t1.t1.application.dtos.AssinaturaDTO;
import com.t1.t1.application.dtos.AssinaturaRequestDTO;
import com.t1.t1.application.dtos.AssinaturaTipoRequestDTO;
import com.t1.t1.application.usecases.aplicativo.AssinarAplicativoUseCase;
import com.t1.t1.application.usecases.assinaturas.BuscarDataFimVigenciaDaAssinaturaUseCase;
import com.t1.t1.application.usecases.assinaturas.ListarAssinaturasUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/servcad/assinaturas")
public class AssinaturaController {

    final AssinarAplicativoUseCase assinarAplicativoUseCase;
    final ListarAssinaturasUseCase listarAssinaturasUseCase;
    final BuscarDataFimVigenciaDaAssinaturaUseCase buscarDataFimVigenciaDaAssinaturaUseCase;
    final Logger logger = Logger.getLogger(AssinaturaController.class.getName());


    public AssinaturaController(AssinarAplicativoUseCase assinarAplicativoUseCase, ListarAssinaturasUseCase listarAssinaturasUseCase, BuscarDataFimVigenciaDaAssinaturaUseCase buscarDataFimVigenciaDaAssinaturaUseCase
    ) {
        this.assinarAplicativoUseCase = assinarAplicativoUseCase;
        this.listarAssinaturasUseCase = listarAssinaturasUseCase;
        this.buscarDataFimVigenciaDaAssinaturaUseCase = buscarDataFimVigenciaDaAssinaturaUseCase;
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

    //get endDate by id
    @GetMapping(value = "/{id}/endDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LocalDate> getEndDate(@PathVariable Long id) {
        try {
            logger.info("Buscando data de fim de vigência da assinatura " + id);
            LocalDate endDate = buscarDataFimVigenciaDaAssinaturaUseCase.call(id);

            if (endDate == null) {
                logger.severe("Data de fim de vigência da assinatura " + id + " não encontrada");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            logger.info("Data de fim de vigência da assinatura " + id + ": " + endDate);
            return ResponseEntity.ok(endDate);

        } catch (Exception e) {
            logger.severe("Erro ao buscar data de fim de vigência da assinatura " + id + ": " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

