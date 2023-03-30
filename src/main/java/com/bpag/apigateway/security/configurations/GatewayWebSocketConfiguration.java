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

    private final String[] URL_WEBSOCKET = {"/sign-in",
                                            "/sign-up",
                                            "/create-wallet-request",
                                            "/reserve",
                                            "/response",
                                            "/get-list-reservation",
                                            "/get-reservation",
                                            "/add-money-wallet",
                                            "/get-report-admin",
                                            "/wallet-reservation",
                                            "/cancel-reservation",
                                            "/update-reservation",
                                            "/local-reservation",
                                            "/sp32",
                                            "/sp32-response"};

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        registry.setApplicationDestinationPrefixes("/ag");
        registry.enableSimpleBroker(URL_WEBSOCKET);
        registry.setUserDestinationPrefix("/response");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*");
        //registry.addEndpoint("/ws").setAllowedOriginPatterns("*");
    }

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registration){
        registration.setMessageSizeLimit(2048 * 2048);
        registration.setSendBufferSizeLimit(2048 * 2048);
        registration.setSendTimeLimit(2048 * 2048);
    }

}