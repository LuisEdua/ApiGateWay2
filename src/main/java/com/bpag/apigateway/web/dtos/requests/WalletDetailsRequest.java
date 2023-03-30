package com.bpag.apigateway.web.dtos.requests;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import lombok.*;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WalletDetailsRequest {

    @JsonProperty("wallet_code")
    private String walletCode;

    @JsonProperty("session_id")
    private String sessionId;

}
