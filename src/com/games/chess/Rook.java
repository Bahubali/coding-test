package com.games.chess;

/**
 * Created by bahubali.n on 16/06/19.
 */
public class Rook extends Piece {

    public Rook(String color) {
        super(color, "R");
    }
    @Override
    public boolean isValidMove(final Panel panel) {
        return false;
    }
}
