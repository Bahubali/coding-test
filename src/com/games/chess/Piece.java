package com.games.chess;

/**
 * Created by bahubali.n on 16/06/19.
 */
public abstract class Piece {

    private Position position;
    private String color;
    private String name;

    protected void setPosition(Position position) {
        this.position = position;
    }
    protected void setColor(String color) { this.color = color; }
    protected void setName(String name) { this.name = name; }

    public String getName() {
        return color.concat(name);
    }
    public Position getPosition() {
        return position;
    }
    public abstract boolean isValidMove(Position position);
}
