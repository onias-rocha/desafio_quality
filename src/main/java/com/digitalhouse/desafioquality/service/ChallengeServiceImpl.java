package com.digitalhouse.desafioquality.service;

import com.digitalhouse.desafioquality.entity.Property;
import com.digitalhouse.desafioquality.repository.PropertyRepository;
import org.springframework.stereotype.Service;

@Service
public class ChallengeServiceImpl implements ChallengeService {

    PropertyRepository repository;

    public ChallengeServiceImpl(PropertyRepository repository) {
        this.repository = repository;
    }

    @Override

    public Double calculateSquareMeters(Property property) {
        return repository.getPropertiesSquareMeters(property);
    }
}
