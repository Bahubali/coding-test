package com.games.chess;

/**
 * Created by bahubali.n on 18/06/19.
 */
public class Bishop extends Piece {

    public Bishop(String color) {
        this.setColor(color);
        this.setName("B");
    }
    @Override
    public boolean isValidMove(Position position) {
        return false;
    }
}
