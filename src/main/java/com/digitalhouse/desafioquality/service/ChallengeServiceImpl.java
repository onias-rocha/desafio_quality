package com.digitalhouse.desafioquality.service;

import com.digitalhouse.desafioquality.entity.District;
import com.digitalhouse.desafioquality.entity.Property;
import com.digitalhouse.desafioquality.repository.PropertyRepository;
import org.springframework.stereotype.Service;

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
            found = new District();
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
}
