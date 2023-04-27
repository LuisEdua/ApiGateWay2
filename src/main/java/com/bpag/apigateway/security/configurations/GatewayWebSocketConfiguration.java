package com.bpag.apigateway.security.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

@EnableWebSocketMessageBroker
@Configuration
public class GatewayWebSocketConfiguration implements WebSocketMessageBrokerConfigurer {


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        registry.setApplicationDestinationPrefixes("/ag");
        registry.enableSimpleBroker("/response");
        registry.setUserDestinationPrefix("/response");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("http://18.232.239.132:5173/", "localhost:5173")
                .setAllowedOrigins("http://18.232.239.132:5173/", "http://localhost:5173")
                .withSockJS()
                .setWebSocketEnabled(true);
    }

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registration){
        registration.setMessageSizeLimit(2048 * 2048);
        registration.setSendBufferSizeLimit(2048 * 2048);
        registration.setSendTimeLimit(2048 * 2048);
    }

}