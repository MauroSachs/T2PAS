package com.example.AssCache.adapter.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
public class SCAAClient {

    private final RestTemplate restTemplate;
    private final String scaaUrl;

    @Autowired
    public SCAAClient(RestTemplate restTemplate, @Value("${SCAA_URL}") String scaaUrl) {
        this.restTemplate = restTemplate;
        this.scaaUrl = scaaUrl;
    }

    public LocalDate consultarAssinatura(Long id) {
        String url = scaaUrl + "/servcad/assinaturas/" + id + "/endDate";

        try {
            return restTemplate.getForObject(url, LocalDate.class);
        } catch (Exception e) {
            System.err.println("Erro ao consultar assinatura no SCAA: " + e.getMessage());
            return null;
        }
    }
}
