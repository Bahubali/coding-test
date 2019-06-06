package com.recommendations;

/**
 * Created by bahubali.n on 27/05/19.
 */
public class Rating {

    private Double score;
    private User ratedBy;

    public Rating(Double score, User ratedBy) {
        this.score = score;
        this.ratedBy = ratedBy;
    }
}
