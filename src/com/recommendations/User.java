package com.recommendations;

import java.util.List;

/**
 * Created by bahubali.n on 27/05/19.
 */
public class User {

    private String firstName;
    private String lastName;
    private UserType userType;
    List<Movie> watchedMovies;

    public User(String firstName, UserType userType) {
        this.firstName = firstName;
        this.userType = userType;
    }


    public enum UserType {
        AUDIENCE, CRITIC, TOP_CRITIC;
    }

}
