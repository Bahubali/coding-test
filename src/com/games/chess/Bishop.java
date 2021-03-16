package com.games.chess;

/**
 * Created by bahubali.n on 18/06/19.
 */
public class Bishop extends Piece {

    public Bishop(String color) {
        super(color, "B");
    }
    @Override
    public boolean isValidMove(Panel panel) {
        return false;
    }
}
