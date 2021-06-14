package com.digitalhouse.desafioquality.service;

import com.digitalhouse.desafioquality.entity.District;
import com.digitalhouse.desafioquality.entity.Property;

public interface ChallengeService {

    District auxDistrictValues(District district);

    Double calculateSquareMeters(Property property);
}
