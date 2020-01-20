package com.galaxy.ratingsdataservice.model;
import lombok.Data;

@Data
public class Rating {

    private String carName;
    private int rating;

    public Rating(String carName, int rating) {
        this.carName = carName;
        this.rating = rating;
    }

}
