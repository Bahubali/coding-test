package com.games.chess;

/**
 * Created by bahubali.n on 16/06/19.
 */
public abstract class Panel {

    protected Position position;
    protected Piece piece;
    protected final String color;

    public Panel(Position position, String color) {
        this.position = position;
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }

    public String getColor() {
        return color;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
