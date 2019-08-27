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
    public boolean isValidMove(Panel panel) {
        boolean isValidMove = true;
        Position position = getPosition();
        if (position.getRow() == panel.getPosition().getRow()) {
            int steps = Math.abs(position.getColumn() - panel.getPosition().getColumn());
            isValidMove = (steps > 1)? false : true;

        } else if (position.getColumn() == panel.getPosition().getColumn()) {
            int steps = Math.abs(position.getColumn() - panel.getPosition().getColumn());
            isValidMove = (steps > 1)? false : true;
        }
        if (isValidMove) {
            if (panel.getPiece().getColor().equals(this.getColor())) {
                isValidMove = false;
            }
        }
        return isValidMove;
    }
}
