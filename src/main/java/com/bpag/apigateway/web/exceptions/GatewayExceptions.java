package com.bpag.apigateway.web.exceptions;

import com.bpag.apigateway.security.configurations.GatewayBasicResponseConfiguration;
import com.bpag.apigateway.web.dtos.responses.BaseResponse;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GatewayExceptions {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private GatewayBasicResponseConfiguration baseResponse;

    /*@RabbitListener(queues = "queue.users_errors")
    public void exceptionUsers(String exception) throws IOException {
        BaseResponse exceptions = baseResponse.exceptions(exception);
        simpMessagingTemplate.convertAndSendToUser(exceptions.getSessionId(),"/exceptions", exceptions);
    }

    @RabbitListener(queues = "queue.reservation_exceptions")
    public void exceptionReservations(String exception) throws IOException {
        BaseResponse exceptions = baseResponse.exceptions(exception);
        simpMessagingTemplate.convertAndSendToUser(exceptions.getSessionId(),"/exceptions", exceptions);
    }*/

    @RabbitListener(queues = "queue.errors")
    public void exception(String exception) throws IOException {
        BaseResponse exceptions = baseResponse.exceptions(exception);
        simpMessagingTemplate.convertAndSendToUser(exceptions.getSessionId(),"/exceptions", exceptions);
    }

}