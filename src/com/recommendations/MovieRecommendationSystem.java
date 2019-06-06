package com.recommendations;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by bahubali.n on 27/05/19.
 */
public class MovieRecommendationSystem {

    public static void main(String[] args) {
        String input = "Mission impossible,action,v1,audience,5";
        String[] inputSplt = input.split(",");
        List<Movie> movieList = new ArrayList<>();
        Movie movie = new Movie(inputSplt[0], inputSplt[1]);
        User user = new User(inputSplt[2], User.UserType.AUDIENCE);
        Rating rating = new Rating(Double.valueOf(inputSplt[3]), user);
        movie.addRating(rating);
        movieList.add(movie);
    }
}
