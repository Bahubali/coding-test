package com.recommendations;

import java.util.List;

/**
 * Created by bahubali.n on 27/05/19.
 */
public class Movie {

    private String name;
    private String genre;

    List<Rating> userRatings;

    public Movie(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public void addRating(Rating rating) {
        if (rating != null) {
            this.userRatings.add(rating);
        }
    }
}
