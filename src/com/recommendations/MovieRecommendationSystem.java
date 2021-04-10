package com.recommendations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bahubali.n on 27/05/19.
 */
public class MovieRecommendationSystem {

    Map<Movie.Genre, List<Movie>> moviesByGenre;
    MovieRecommendationSystem() {
        this.moviesByGenre = new HashMap<>();
    }

    public void execute(Command command) {
        switch (command.getCommandType()){
            case ADD_MOVIE:
                //Movie movie = new Movie(command.getMovieName(), command.getGenre());
                break;
            default:
        }
    }
    private Movie.Genre getMovieGenre(String genre) {
        switch (genre){
            case "ROMANTIC":
                return Movie.Genre.ROMANTIC;
            default:
        }
        return Movie.Genre.ACTION;
    }
    public static void main(String[] args) {
        String input = "Mission impossible,action,v1,audience,5";
        String[] inputSplt = input.split(",");
        List<Movie> movieList = new ArrayList<>();
        Movie movie = new Movie(inputSplt[0], Movie.Genre.ACTION);
        User user = new User(inputSplt[2], User.UserType.AUDIENCE);
        Rating rating = new Rating(Double.valueOf(inputSplt[3]), user, Rating.RatingType.AUDIENCE);
        movie.addRating(rating);
        movieList.add(movie);
    }
}
