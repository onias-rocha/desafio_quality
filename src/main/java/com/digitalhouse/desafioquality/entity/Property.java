package com.digitalhouse.desafioquality.entity;

import lombok.Data;

import java.util.List;

@Data
public class Property {
    private String name;
    private District district;
    private List<Room> rooms;
}
