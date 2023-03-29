package com.bpag.apigateway.services.interfaces;

public interface IGatewayRabbitMQConfiguration {

    public void sendRequests(String queue, Object request);

}