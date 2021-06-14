package com.digitalhouse.desafioquality.rest;

import com.digitalhouse.desafioquality.entity.Room;
import com.digitalhouse.desafioquality.rest.dto.PropertyRequestDTO;

public interface ChallengeController {
    public String welcomeMessage();
    public Double calculateSquareMeters(PropertyRequestDTO property);
    public Double calculatePropertyValue(PropertyRequestDTO property);
    public Room calculateBiggestRoom(PropertyRequestDTO property);
}
