package com.bpag.apigateway.security.configurations;

import com.bpag.apigateway.services.interfaces.IGatewayRabbitMQConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRabbitMQConfiguration implements IGatewayRabbitMQConfiguration {

    @Autowired
    private RabbitTemplate template;

    @Override
    public void sendRequests(String queue, Object request) {
        template.convertAndSend(queue, request);
    }

}