package com.galaxy.ratingsdataservice.model;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class UserRating {

    private String userId;
    private List<Rating> ratings;

    public void initData(String userId) {
        this.setUserId(userId);
        this.setRatings(Arrays.asList(
                new Rating("Porsche", 3),
                new Rating("Aston-Martin", 4)
        ));
    }
}
