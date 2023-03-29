package com.bpag.apigateway.security.configurations;

import com.bpag.apigateway.web.dtos.responses.BaseResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class GatewayBasicResponseConfiguration {

    public static final ObjectMapper mapper = new ObjectMapper();

    public BaseResponse baseResponse(String object) throws JsonProcessingException {
        JsonNode jsonNode = mapper.readTree(object);
        JsonNode data = jsonNode.required("data");
        return BaseResponse.builder()
                .data(data)
                .message(jsonNode.get("message").asText())
                .success(jsonNode.get("success").asBoolean())
                .sessionId(jsonNode.get("sessionId").asText())
                .httpStatus(HttpStatus.valueOf(jsonNode.get("httpStatus").asText()))
                .statusCode(jsonNode.get("statusCode").asInt()).build();
    }

    public BaseResponse exceptions(String object) throws JsonProcessingException {
        JsonNode jsonNode = mapper.readTree(object);
        return BaseResponse.builder()
                .message(jsonNode.get("message").asText())
                .success(jsonNode.get("success").asBoolean())
                .sessionId(jsonNode.get("sessionId").asText())
                .httpStatus(HttpStatus.valueOf(jsonNode.get("httpStatus").asText()))
                .statusCode(jsonNode.get("statusCode").hashCode()).build();
    }

}