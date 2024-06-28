package com.example.AssCache.adapter.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
public class SCAAClient {

    private final RestTemplate restTemplate;

    @Autowired
    public SCAAClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public LocalDate consultarAssinatura(Long id) {
        String url = "http://scaa-service/servcad/assinvalida/" + id;

        try {
            LocalDate dataVencimento = restTemplate.getForObject(url, LocalDate.class);
            return dataVencimento;
        } catch (Exception e) {
            System.err.println("Erro ao consultar assinatura no SCAA: " + e.getMessage());
            return null;
        }
    }
}
