package com.games.chess;

/**
 * Created by bahubali.n on 16/06/19.
 */
public class Knight extends Piece {

    public Knight(String color) {
        super(color, "H");
    }
    @Override
    public boolean isValidMove(Panel panel) {
        return false;
    }
}
