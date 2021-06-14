package com.digitalhouse.desafioquality.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RoomResponseDTO {
    @JsonProperty("room_name")
    String roomName;
    @JsonProperty("square_meters")
    Double squareMeter;
}
