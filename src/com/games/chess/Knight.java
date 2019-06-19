package com.games.chess;

/**
 * Created by bahubali.n on 16/06/19.
 */
public class Knight extends Piece {

    public Knight(String color) {
        this.setColor(color);
        this.setName("H");
    }
    @Override
    public boolean isValidMove(Position position) {
        return false;
    }
}
