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

    protected String getName() {
        return color.concat(name);
    }
    protected String getColor() { return this.color; }
    protected Position getPosition() {
        return this.position;
    }
    public abstract boolean isValidMove(Panel panel);
}
