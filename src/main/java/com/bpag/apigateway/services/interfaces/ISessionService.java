package com.bpag.apigateway.services.interfaces;

import com.bpag.apigateway.web.dtos.responses.BaseResponse;

public interface ISessionService {

    public BaseResponse generatorSessionCode();

}