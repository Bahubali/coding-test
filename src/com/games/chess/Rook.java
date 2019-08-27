package com.games.chess;

/**
 * Created by bahubali.n on 16/06/19.
 */
public class Rook extends Piece {

    public Rook(String color) {
        this.setColor(color);
        this.setName("R");
    }
    @Override
    public boolean isValidMove(final Panel panel) {
        return false;
    }
}
