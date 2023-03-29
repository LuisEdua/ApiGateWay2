package com.bpag.apigateway.utilities.enums;

import lombok.Getter;

@Getter
public enum GatewayQueueEnum {

    QUEUE_USERS_ERROR("queue.users_errors"),
    QUEUE_USERS_RESPONSES("queue.users_responses"),
    QUEUE_USERS_SIGN_IN("queue.users_sign_in"),
    QUEUE_USERS_SIGN_UP("queue.users_sign_up"),
    QUEUE_RESERVATION_CREATE("queue.reservation_create"),
    QUEUE_RESERVATION_RESPONSES("queue.reservation_responses"),
    QUEUE_RESERVATIONS_EXCEPTIONS("queue.reservation_exceptions"),
    QUEUE_RESERVATION_DAY_LIST("queue.reservation_day_list"),
    QUEUE_RESERVATION_USER_LIST("queue.reservation_user_list"),
    QUEUE_WALLET_ADD_MONEY("queue.wallet_add_money"),
    QUEUE_ADMIN_REPORT_REQUEST("queue.admin_report_request"),
    QUEUE_ERRORS("queue.errors"),
    QUEUE_WALLET_RESPONSE("queue.wallet_response"),
    QUEUE_WALLET_CREATE("queue.wallet_create"),
    QUEUE_RESERVATION_WALLET("queue.reservation_wallet"),
    QUEUE_RESERVATION_CANCEL("queue.reservation_cancel"),
    QUEUE_RESERVATION_LOCAL("queue.reservation_local");

    private String queue;

    GatewayQueueEnum(String code){
        this.queue=code;
    }

}