package com.digitalhouse.desafioquality.repository.impl;

import com.digitalhouse.desafioquality.entity.District;
import com.digitalhouse.desafioquality.entity.Property;
import com.digitalhouse.desafioquality.entity.Room;
import com.digitalhouse.desafioquality.repository.PropertyRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PropertyRepositoryImpl implements PropertyRepository {

    List<District> districts;

    public PropertyRepositoryImpl() {
        districts = new ArrayList<>();

        District ribeirao = new District("Ribeirão do Lipa", 1500.0);
        District goiabeiras = new District("Goiabeiras", 2400.0);
        District centro = new District("Centro", 2500.0);
        District santaRosa = new District("Santa Rosa", 2100.0);

        districts.add(ribeirao);
        districts.add(goiabeiras);
        districts.add(centro);
        districts.add(santaRosa);
    }

    @Override
    public Double getPropertiesSquareMeters(Property property) {
        Double squareMeters = 0.0;

        for(Room r1 : property.getRooms()){
            squareMeters += r1.getLength() * r1.getWidth();
        }

        return squareMeters;
    }

    @Override
    public Double getPropertiesValue(Property property) {
        return null;
    }

    @Override
    public String getBiggestRoom(Property property) {
        return null;
    }

    @Override
    public String getEachRoomsSquareMeters(Property property) {
        return null;
    }
}
