package com.recommendations;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Command {
    private String movieName;
    private String genre;
    private String ratingType;
    private int rating;
    private CommandType commandType;

    public enum CommandType {
        ADD_MOVIE, ADD_RATING, RECOMMEND;
    }

}
