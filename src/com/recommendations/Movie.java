package com.recommendations;

import java.util.List;

/**
 * Created by bahubali.n on 27/05/19.
 */
public class Movie {

    private String name;
    private Genre genre;

    List<Rating> userRatings;

    public Movie(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
    }

    public void addRating(Rating rating) {
        if (rating != null) {
            this.userRatings.add(rating);
        }
    }

    public enum Genre {
        ROMANTIC, ACTION, COMEDY, FAMILY, A;
    }
}
