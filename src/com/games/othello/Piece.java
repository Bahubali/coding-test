package com.games.othello;

import lombok.Builder;

public class Piece {
    private Color color;
    public Piece(Color color) { this.color = color; }

    public void flip() {
        if (this.color == Color.WHITE) color = Color.BLACK;
        else color = Color.WHITE;
    }

    public Color getColor() { return this.color; }
}
