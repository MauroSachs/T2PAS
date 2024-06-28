package com.t1.t1.core;//package com.t1.t1.core;
//
//import org.springframework.amqp.core.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitMQConfig {
//
//    @Bean
//    public Queue assinaturaUpdateQueue() {
//        return new Queue("assinatura.update.queue", true);
//    }
//
//    @Bean
//    public FanoutExchange assinaturaUpdateExchange() {
//        return new FanoutExchange("assinatura.update.exchange");
//    }
//
//    @Bean
//    public Binding binding(Queue assinaturaUpdateQueue, FanoutExchange assinaturaUpdateExchange) {
//        return BindingBuilder.bind(assinaturaUpdateQueue).to(assinaturaUpdateExchange);
//    }
//}

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String FANOUTEXCHANGENAME = "assinatura.update.exchange";

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUTEXCHANGENAME);
    }
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory, MessageConverter messageConverter) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
}