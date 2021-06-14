package com.digitalhouse.desafioquality.entity;

import lombok.Data;

@Data
public class Room {
    private String name;
    private Double width;
    private Double length;

    public Room(String name, Double width, Double length) {
        this.name = name;
        this.width = width;
        this.length = length;
    }

    public Room() {
    }
}
