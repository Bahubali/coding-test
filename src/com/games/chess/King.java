package com.games.chess;

/**
 * Created by bahubali.n on 16/06/19.
 */
public class King extends Piece {

    public King(String color) {
        this.setColor(color);
        this.setName("K");
    }
    @Override
    public boolean isValidMove(Position position) {
        return false;
    }
}
