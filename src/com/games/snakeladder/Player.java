package com.games.snakeladder;

/**
 * Created by bahubali.n on 27/05/19.
 */
public class Player {
    private String name;
    private Position currentPosition;

    public Player(String name) {
        this.name = name;
        this.currentPosition = new Position(9, 0);
    }

    public void setCurrentPosition(Position position) {
        this.currentPosition = position;
    }

    public Position getCurrentPosition() {
        return this.currentPosition;
    }

    public String getName() {
        return this.name;
    }
}
