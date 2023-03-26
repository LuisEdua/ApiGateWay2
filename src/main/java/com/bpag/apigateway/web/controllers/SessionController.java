package com.bpag.apigateway.web.controllers;

import com.bpag.apigateway.services.interfaces.ISessionService;
import com.bpag.apigateway.web.dtos.responses.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("session")
@Slf4j
public class SessionController {

    @Autowired
    private ISessionService service;

    @GetMapping("/session-id")
    public BaseResponse generateCode(){
        return service.generatorSessionCode();
    }

}