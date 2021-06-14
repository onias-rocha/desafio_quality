package com.digitalhouse.desafioquality.repository;

import com.digitalhouse.desafioquality.entity.District;
import com.digitalhouse.desafioquality.entity.Property;

import java.util.List;

public interface PropertyRepository {

    public Double getPropertiesSquareMeters(Property property);

    public Double getPropertiesValue(Property property);

    public String getBiggestRoom(Property property);

    public String getEachRoomsSquareMeters(Property property);

    public List<District> getAllDistricts();
}
