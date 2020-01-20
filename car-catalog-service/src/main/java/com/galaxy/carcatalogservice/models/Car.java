package com.galaxy.carcatalogservice.models;

public class Car {
    private String carId;
    private String name;
    private String description;

    public Car() {}

    public Car(String carId, String name, String description) {
        this.carId = carId;
        this.name = name;
        this.description = description;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
