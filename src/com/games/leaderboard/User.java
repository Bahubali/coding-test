package com.games.leaderboard;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User implements Comparable<User> {

    private String name;
    private String email;
    private int score;
    private int rank;

    @Override
    public int compareTo(User o) {
        return (this.getScore() > o.getScore())? 1 : 0;
    }
}
