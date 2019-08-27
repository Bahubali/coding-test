package com.games.chess;

/**
 * Created by bahubali.n on 16/06/19.
 */
public class Pawn extends Piece {

    public Pawn(String color) {
        this.setColor(color);
        this.setName("P");
    }

    @Override
    public boolean isValidMove(Panel panel) {
        Position currentPosition = getPosition();

        return false;
    }
}
