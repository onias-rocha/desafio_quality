package com.digitalhouse.desafioquality.service;

import com.digitalhouse.desafioquality.entity.District;
import com.digitalhouse.desafioquality.entity.Property;
import com.digitalhouse.desafioquality.entity.Room;
import com.digitalhouse.desafioquality.rest.dto.PropertyRequestDTO;

public interface ChallengeService {

    District auxDistrictValues(District district);
    Double calculateSquareMeters(Property property);
    Double calculatePropertyValue(PropertyRequestDTO property);
    Room calculateBiggestRoom(PropertyRequestDTO property);
}
