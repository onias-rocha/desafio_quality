package com.digitalhouse.desafioquality.service;

import com.digitalhouse.desafioquality.entity.District;
import com.digitalhouse.desafioquality.entity.Property;
import com.digitalhouse.desafioquality.entity.Room;
import com.digitalhouse.desafioquality.repository.PropertyRepository;
import com.digitalhouse.desafioquality.rest.dto.PropertyRequestDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ChallengeServiceImpl implements ChallengeService {

    PropertyRepository repository;

    public ChallengeServiceImpl(PropertyRepository repository) {
        this.repository = repository;
    }


    @Override
    public District auxDistrictValues(District district) {
        List<District> availableDistricts = repository.getAllDistricts();
        District found = null;
        for(District d1 : availableDistricts){
            if(d1.getName().toLowerCase(Locale.ROOT).equals(district.getName().toLowerCase(Locale.ROOT))){
                found = d1;
            }
        }
        return found;
    }

    @Override
    public Double calculateSquareMeters(Property property) {
        return repository.getPropertiesSquareMeters(property);
    }

    @Override
    public Double calculatePropertyValue(PropertyRequestDTO property) {
        Property prop = property.turnIntoProperty();
        District d1 = auxDistrictValues(prop.getDistrict());
        return calculateSquareMeters(property.turnIntoProperty()) * d1.getPricePerSquareMeter();
    }

    @Override
    public Room calculateBiggestRoom(PropertyRequestDTO property) {
        Property prop = property.turnIntoProperty();
        List<Room> rooms = prop.getRooms();

        Room bigger = null;

        for(Room room: rooms){
            if (bigger == null){
                bigger = room;
            }else if((room.getWidth() * room.getLength()) > bigger.getWidth() * bigger.getLength()){
                bigger = room;
            }
        }
        return bigger;
    }


}
