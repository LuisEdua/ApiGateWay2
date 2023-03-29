package com.bpag.apigateway.security.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;
import org.springframework.security.config.annotation.web.socket.EnableWebSocketSecurity;

//@Configuration
public class WebSocketSecurityConfig {//extends AbstractSecurityWebSocketMessageBrokerConfigurer {

    /*protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
        messages.simpDestMatchers("/ws/**").authenticated()
                .anyMessage().authenticated();
    }*/

}