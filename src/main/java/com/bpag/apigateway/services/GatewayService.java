package com.bpag.apigateway.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Slf4j
@Controller
public class GatewayService {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private RabbitTemplate template;

    @RabbitListener(queues = {"queue.movies_responses", "queue.movies_errors"})
    public void createUserResponse(String payload) throws IOException {
        System.out.println(payload);
        simpMessagingTemplate.convertAndSendToUser("xd", "/view/movies", payload);
    }

    @MessageMapping("/view")
    private void signUp(String request){
        template.convertAndSend("queue.movies", request);
    }

}