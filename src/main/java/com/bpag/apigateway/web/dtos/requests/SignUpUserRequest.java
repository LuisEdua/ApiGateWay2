package com.bpag.apigateway.web.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SignUpUserRequest {

    @NotEmpty @NotNull
    private String name;

    @Email @NotEmpty @NotNull
    private String email;

    @NotEmpty
    @Size(min = 8, message = "The password should have 8 characters min.")
    private String password;

    @NotEmpty @NotNull
    @JsonProperty("session_id")
    private String sessionId;

}