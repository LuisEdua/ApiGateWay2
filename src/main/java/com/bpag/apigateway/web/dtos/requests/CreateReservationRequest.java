package com.bpag.apigateway.web.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateReservationRequest {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("iso_date_time")
    private String isoDateTime;

    @JsonProperty("slot_number")
    private String slotNumber;

    @JsonProperty("session_id")
    private String sessionId;

}