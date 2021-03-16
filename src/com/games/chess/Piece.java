package com.games.chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bahubali.n on 16/06/19.
 */
public abstract class Piece {

    private Position position;
    private String color;
    private String name;
    private List<Move> moves;

    Piece(String color, String name) {
        this.color = color;
        this.name = name;
        this.moves = new ArrayList<>();
    }

    protected void setPosition(Position position) {
        this.position = position;
    }
    protected void setColor(String color) { this.color = color; }
    protected void setName(String name) { this.name = name; }
    protected void setMove(Move move) { this.moves.add(move); }

    protected String getName() {
        return color.concat(name);
    }
    protected String getColor() { return this.color; }
    protected Position getPosition() {
        return this.position;
    }
    protected List<Move> getMoves() { return this.moves; }

    protected Integer totalNoOfMoves() { return this.moves.size(); }
    public abstract boolean isValidMove(Panel panel);
}
