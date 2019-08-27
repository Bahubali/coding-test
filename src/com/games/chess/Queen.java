package com.games.chess;

/**
 * Created by bahubali.n on 16/06/19.
 */
public class Queen extends Piece {


    public Queen(String color) {
        this.setColor(color);
        this.setName("Q");
    }

    @Override
    public boolean isValidMove(Panel panel) {
        return false;
    }
}
