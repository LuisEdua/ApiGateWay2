package com.bpag.apigateway.web.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SignInUserRequest {

    @Email @NotEmpty @NotNull
    private String email;

    @NotEmpty @NotNull
    private String password;

    @NotEmpty @NotNull
    @JsonProperty("session_id")
    private String sessionId;

}