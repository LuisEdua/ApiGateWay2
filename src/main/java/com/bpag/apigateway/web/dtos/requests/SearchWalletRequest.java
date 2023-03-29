package com.bpag.apigateway.web.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SearchWalletRequest {

    private String date;

    @NotNull
    @NotEmpty
    @JsonProperty("wallet_code")
    private String walletCode;

    @NotEmpty
    @NotNull
    @JsonProperty("session_id")
    private String sessionId;

}