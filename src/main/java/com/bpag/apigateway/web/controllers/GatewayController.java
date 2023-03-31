package com.bpag.apigateway.web.controllers;

import com.bpag.apigateway.services.interfaces.IGatewayRabbitMQConfiguration;
import com.bpag.apigateway.utilities.GatewayMapperUtil;
import com.bpag.apigateway.utilities.enums.GatewayQueueEnum;
import com.bpag.apigateway.web.dtos.requests.*;
import com.bpag.apigateway.web.dtos.responses.BaseResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class GatewayController {

    @Autowired
    private IGatewayRabbitMQConfiguration rabbitMQ;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/sign-up")
    private void createUserRequest(@Payload SignUpUserRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_USERS_SIGN_UP.getQueue(), GatewayMapperUtil.serialize(request));
    }

    @MessageMapping("/sign-in")
    private void getUserRequest(@Payload SignInUserRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_USERS_SIGN_IN.getQueue(), GatewayMapperUtil.serialize(request));
    }

    @MessageMapping("/reserve")
    private void createReservationRequest(@Payload CreateReservationRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_RESERVATION_CREATE.getQueue(), GatewayMapperUtil.serialize(request));
    }

    @MessageMapping("/get-reservation")
    private void getReservationListRequest(@Payload GetListReservationRequest request) throws JsonProcessingException {

        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_RESERVATION_DAY_LIST.getQueue(), GatewayMapperUtil.serialize(request));
    }

    @MessageMapping("/get-list-reservation")
    private void getListReservationRequest(@Payload GetListReservationRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_RESERVATION_USER_LIST.getQueue(), GatewayMapperUtil.serialize(request));
    }

    @MessageMapping("/wallet-reservation")
    private void reservationByWalletRequest(@Payload SearchWalletRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_RESERVATION_WALLET.getQueue(), GatewayMapperUtil.serialize(request));
    }

    @MessageMapping("/cancel-reservation")
    private void cancelReservationRequest(@Payload CancelReservationRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_RESERVATION_CANCEL.getQueue(), GatewayMapperUtil.serialize(request));
    }

    @MessageMapping("/update-reservation")
    private void updateReservationRequest(@Payload UpdateReservationRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_RESERVATION_CREATE.getQueue(), GatewayMapperUtil.serialize(request));
    }

    @MessageMapping("/local-reservation")
    private void localReservationRequest(@Payload LocalReservationRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_RESERVATION_LOCAL.getQueue(), GatewayMapperUtil.serialize(request));
    }

    @SendTo("/sp32-response")
    private void sp32ReservationRequest(@Payload LocalReservationRequest request) throws JsonProcessingException {
        //BaseResponse payload = baseResponse.baseResponse(walletResponse);
        simpMessagingTemplate.convertAndSend("/private", request);

        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_RESERVATION_LOCAL.getQueue(), GatewayMapperUtil.serialize(request));
    }

    @MessageMapping("/add-money-wallet")
    private void addMoneyToWalletRequest(@Payload AddCashRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_WALLET_ADD_MONEY.getQueue(), GatewayMapperUtil.serialize(request));
    }

    @MessageMapping("/get-report-admin")
    private void adminReportRequest(@Payload AdminReportRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_ADMIN_REPORT_REQUEST.getQueue(), GatewayMapperUtil.serialize(request));
    }

    @MessageMapping("/create-wallet-request")
    private void adminRequest(@Payload CreateWalletRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests(GatewayQueueEnum.QUEUE_WALLET_CREATE.getQueue(), GatewayMapperUtil.serialize(request));
    }

    @MessageMapping("/wallet-details")
    private void details(@Payload WalletDetailsRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests("queue.wallet_money", GatewayMapperUtil.serialize(request));
    }

    @MessageMapping("/get-slots")
    private void getSlot(@Payload GetSlotRequest request) throws JsonProcessingException {
        rabbitMQ.sendRequests("queue.get_slots", GatewayMapperUtil.serialize(request));
    }

}