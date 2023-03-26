package com.bpag.apigateway.web.controllers;

import com.bpag.apigateway.services.interfaces.IGatewayRabbitMQConfiguration;
import com.bpag.apigateway.utilities.GatewayMapperUtil;
import com.bpag.apigateway.utilities.enums.GatewayQueueEnum;
import com.bpag.apigateway.web.dtos.requests.AdminReportRequest;
import com.bpag.apigateway.web.dtos.requests.GetListReservationRequest;
import com.bpag.apigateway.web.dtos.requests.SignUpUserRequest;
import com.bpag.apigateway.web.dtos.requests.AddMoneyRequest;
import com.bpag.apigateway.web.dtos.requests.SignInUserRequest;
import com.bpag.apigateway.web.dtos.requests.CreateReservationRequest;
import com.bpag.apigateway.web.dtos.requests.GetReservationRequest;
import com.bpag.apigateway.web.dtos.requests.GetCodeWalletRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class GatewayController {

    @Autowired
    private IGatewayRabbitMQConfiguration rabbitMQ;

    @MessageMapping("/signup")
    private void createUserRequest(@Payload SignUpUserRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_USERS_SIGN_UP.getQueue(), GatewayMapperUtil.serialize(request));
    }

    @MessageMapping("/signin")
    private void getUserRequest(@Payload SignInUserRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_USERS_SIGN_IN.getQueue(), GatewayMapperUtil.serialize(request));
    }

    @MessageMapping("/reseve")
    private void createReservationRequest(@Payload CreateReservationRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_RESERVATION_CREATE.getQueue(), GatewayMapperUtil.serialize(request));
    }

    @MessageMapping("/get-reservation")
    private void getReservationRequest(@Payload GetReservationRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_RESERVATION_DAY_LIST.getQueue(), GatewayMapperUtil.serialize(request));
    }

    @MessageMapping("/get-list-reservation")
    private void getListReservationRequest(@Payload GetListReservationRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_RESERVATION_USER_LIST.getQueue(), GatewayMapperUtil.serialize(request));
    }
    //no se cuales son los request de admin ni de walllet
    @MessageMapping("/add-money-wallet")
    private void addMoneyToWalletRequest(@Payload AddMoneyRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_WALLET_ADD_MONEY.getQueue(), GatewayMapperUtil.serialize(request));
    }

    @MessageMapping("/get-report-admin")
    private void adminReportRequest(@Payload AdminReportRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_ADMIN_REPORT_REQUEST.getQueue(), GatewayMapperUtil.serialize(request));
    }

    @MessageMapping("/admin")
    private void adminRequest(@Payload GetCodeWalletRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_ADMIN_WALLET_CODE_REQUEST.getQueue(), GatewayMapperUtil.serialize(request));
    }

}