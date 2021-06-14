package com.digitalhouse.desafioquality.entity;

import lombok.Data;

@Data
public class District {

    public District(String name, Double pricePerSquareMeter) {
        this.name = name;
        this.pricePerSquareMeter = pricePerSquareMeter;
    }

    public District(String name) {
        this.name = name;
    }

    public District() {
    }

    private String name;
    private Double pricePerSquareMeter;
}
