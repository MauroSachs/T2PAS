package com.example.AssCache.domain.services;

import com.example.AssCache.adapter.clients.SCAAClient;
import com.example.AssCache.domain.entities.AssinaturaEntity;
import com.example.AssCache.domain.repositories.AssinaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AssCacheService {

    private final AssinaturaRepository assinaturaRepository;
    private final SCAAClient scaaClient;

    @Autowired
    public AssCacheService(AssinaturaRepository assinaturaRepository, SCAAClient scaaClient) {
        this.assinaturaRepository = assinaturaRepository;
        this.scaaClient = scaaClient;
    }

    public boolean verificarAssinatura(Long id) {
        LocalDate dataVencimento = consultarAssinaturaLocalmente(id);
        return dataVencimento != null && dataVencimento.isAfter(LocalDate.now());
    }

    private LocalDate consultarAssinaturaLocalmente(Long id) {
        return assinaturaRepository.findById(id)
                .map(AssinaturaEntity::getFimVigencia)
                .orElseGet(() -> consultarAssinaturaNoScaa(id));
    }


    private LocalDate consultarAssinaturaNoScaa(Long id) {
        LocalDate dataVencimento = scaaClient.consultarAssinatura(id);
        if (dataVencimento != null) {
            AssinaturaEntity assinatura = new AssinaturaEntity();
            assinatura.setId(id);
            assinatura.setFimVigencia(dataVencimento);
            assinaturaRepository.save(assinatura);
        }
        return dataVencimento;
    }

    public void receberAtualizacaoAssinatura(Long id, LocalDate novaDataVencimento) {
        AssinaturaEntity assinatura = new AssinaturaEntity();
        assinatura.setId(id);
        assinatura.setFimVigencia(novaDataVencimento);

        assinaturaRepository.save(assinatura);
        System.out.println("Atualização recebida para a assinatura " + id + " - Nova data de vencimento: " + novaDataVencimento);
    }
}