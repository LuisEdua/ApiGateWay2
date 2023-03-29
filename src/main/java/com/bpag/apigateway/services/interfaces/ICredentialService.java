package com.bpag.apigateway.services.interfaces;

import com.bpag.apigateway.persistances.entities.Credential;
import com.bpag.apigateway.web.dtos.responses.BaseResponse;

public interface ICredentialService {

    Credential getToken(String username);

}