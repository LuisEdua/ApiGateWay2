package com.bpag.apigateway.web.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UpdateReservationRequest {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("reservation_id")
    private Long reservation_id;

    @JsonProperty("iso_date_time")
    private String isoDateTime;

    @JsonProperty("slot_number")
    private String slotNumber;

    @JsonProperty("session_id")
    private String sessionId;

}