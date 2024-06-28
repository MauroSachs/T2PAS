package com.example.AssCache.adapter.controller;

import com.example.AssCache.domain.services.AssCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class AssinaturaController {

    private final AssCacheService assCacheService;
    private final Logger logger = Logger.getLogger(AssinaturaController.class.getName());

    @Autowired
    public AssinaturaController(AssCacheService assCacheService) {
        this.assCacheService = assCacheService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boolean> verificarAssinatura(@PathVariable Long id) {
        logger.info("Verificando assinatura " + id);
        try {
            boolean assinaturaValida = assCacheService.verificarAssinatura(id);
            return ResponseEntity.ok(assinaturaValida);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
