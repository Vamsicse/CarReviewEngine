package com.galaxy.carinfoservice.models;
import lombok.Data;

@Data
public class Car {
    private String carId;
    private String name;
    private String description;

    public Car(String carId, String name, String description) {
        this.carId = carId;
        this.name = name;
        this.description = description;
    }

}
