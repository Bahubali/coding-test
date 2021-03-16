package com.games.chess;

/**
 * Created by bahubali.n on 16/06/19.
 */
public class Pawn extends Piece {

    public Pawn(String color) {
        super(color, "P");
    }

    @Override
    public boolean isValidMove(Panel panel) {
        boolean isValidMove = true;
        Position position = getPosition();
        if (position.getRow() == panel.getPosition().getRow()) {
            int steps = Math.abs(position.getColumn() - panel.getPosition().getColumn());
            isValidMove = (steps == 2 && panel.getPiece().totalNoOfMoves() < 1)? false : true;

        } else if (position.getColumn() == panel.getPosition().getColumn()) {
            int steps = Math.abs(position.getRow() - panel.getPosition().getRow());
            isValidMove = (steps == 2 && panel.getPiece().totalNoOfMoves() < 1)? false : true;
        }
        if (isValidMove) {
            if (panel.getPiece() != null && panel.getPiece().getColor().equals(this.getColor())) {
                isValidMove = false;
            }
        }
        return isValidMove;
    }
}
