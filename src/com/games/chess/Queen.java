package com.games.chess;

/**
 * Created by bahubali.n on 16/06/19.
 */
public class Queen extends Piece {


    public Queen(String color) {
        super(color, "Q");
    }

    @Override
    public boolean isValidMove(Panel panel) {
        return false;
    }
}
