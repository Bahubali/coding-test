package com.recommendations;

/**
 * Created by bahubali.n on 27/05/19.
 */
public class Rating {

    private Double score;
    private User ratedBy;
    private RatingType ratingType;

    public Rating(Double score, User ratedBy, RatingType type) {
        this.score = score;
        this.ratedBy = ratedBy;
        this.ratingType = type;
    }

    public enum RatingType {
        AUDIENCE, CRITIC, TOP_CRITIC
    }
}
