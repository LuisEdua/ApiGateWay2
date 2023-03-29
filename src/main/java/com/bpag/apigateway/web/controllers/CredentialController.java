package com.bpag.apigateway.web.controllers;

import com.bpag.apigateway.services.interfaces.ICredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("credential")
public class CredentialController {

    @Autowired
    private ICredentialService service;

    @GetMapping
    public String getCredential(){
        return "Ok";
    }

}