package com.galaxy.carcatalogservice.models;

public class Rating {

    private String carId;
    private int rating;

    public Rating() {

    }

    public Rating(String carId, int rating) {
        this.carId = carId;
        this.rating = rating;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
