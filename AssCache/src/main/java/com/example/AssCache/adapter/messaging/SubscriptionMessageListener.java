package com.example.AssCache.adapter.messaging;

import com.example.AssCache.domain.services.AssCacheService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.logging.Logger;

@Component
public class SubscriptionMessageListener {

    private final AssCacheService assCacheService;
    private final Logger logger = Logger.getLogger(SubscriptionMessageListener.class.getName());

    @Autowired
    public SubscriptionMessageListener(AssCacheService assCacheService) {
        this.assCacheService = assCacheService;
    }

    @RabbitListener(queues = "#{rabbitMQConfig.queue.name}")
    public void receiveMessage(String message) {
        logger.info("Mensagem recebida: " + message);
        String[] parts = message.split(":");
        Long id = Long.parseLong(parts[0]);
        String fimVigencia = parts[1];
        LocalDate fimVigenciaDate = LocalDate.parse(fimVigencia);
        logger.info("Recebida mensagem de atualização de assinatura para a assinatura " + id + " - Nova data de vencimento: " + fimVigencia);
        assCacheService.receberAtualizacaoAssinatura(id, fimVigenciaDate);
    }
}
