package com.games.chess;

/**
 * Created by bahubali.n on 16/06/19.
 */
public class Root extends Piece {

    public Root(String color) {
        this.setColor(color);
        this.setName("R");
    }
    @Override
    public boolean isValidMove(final Position position) {
        return false;
    }
}
