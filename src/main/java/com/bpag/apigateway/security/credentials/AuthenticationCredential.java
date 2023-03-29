package com.bpag.apigateway.security.credentials;

import lombok.Data;

@Data
public class AuthenticationCredential {

    private String email;
    private String password;

}