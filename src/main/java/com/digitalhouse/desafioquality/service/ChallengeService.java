package com.digitalhouse.desafioquality.service;

import com.digitalhouse.desafioquality.entity.District;
import com.digitalhouse.desafioquality.entity.Property;
import com.digitalhouse.desafioquality.entity.Room;
import com.digitalhouse.desafioquality.rest.dto.PropertyRequestDTO;

import java.util.ArrayList;
import java.util.List;

public interface ChallengeService {

    District auxDistrictValues(District district);
    Double calculateSquareMeters(PropertyRequestDTO property);
    Double calculatePropertyValue(PropertyRequestDTO property);
    Room calculateBiggestRoom(PropertyRequestDTO property);
    ArrayList<Double> calculateAllRoomsSquareMeters(PropertyRequestDTO property);
    List<RoomResponseDTO> calculateAllRoomsSquareMetersRestfully(PropertyRequestDTO property);
}
