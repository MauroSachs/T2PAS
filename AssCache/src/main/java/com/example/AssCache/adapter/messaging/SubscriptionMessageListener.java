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
    private final String QUEUE_NAME = "assinatura.update.queue";
    private final Logger logger = Logger.getLogger(SubscriptionMessageListener.class.getName());

    @Autowired
    public SubscriptionMessageListener(AssCacheService assCacheService) {
        this.assCacheService = assCacheService;
    }

    @RabbitListener(queues = QUEUE_NAME)
    public void receiveMessage(String message) {
        String[] parts = message.split(",");
        Long id = Long.parseLong(parts[0]);
        String fimVigencia = parts[1];
        LocalDate fimVigenciaDate = LocalDate.parse(fimVigencia);
        logger.info("Recebida mensagem de atualização de assinatura para a assinatura " + id + " - Nova data de vencimento: " + fimVigencia);
        assCacheService.receberAtualizacaoAssinatura(id, fimVigenciaDate);
    }
}

//o que essa classe faz?
//Essa classe é responsável por ouvir mensagens de atualização de assinatura vindas de uma fila do RabbitMQ e atualizar a data
//como ela funciona?
//A classe é um componente do Spring que é anotado com @Component e possui um método anotado com @RabbitListener que é chamado
//qual fila ele escuta?
//A fila que ele escuta é a "subscriptionQueue"
//falta alguma configuração para que ele funcione?
//Sim, é necessário configurar o RabbitMQ no arquivo application.properties ou application.yml
