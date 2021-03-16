package com.games.chess;

/**
 * Created by bahubali.n on 16/06/19.
 */
public class Move {

    private Player player;

    private Position fromPosition;

    private Position toPosition;

    Move(final Player player, final Position from, final Position to) {
        this.player = player;
        this.fromPosition = from;
        this.toPosition = to;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Position getFromPosition() {
        return this.fromPosition;
    }

    public Position getToPosition() { return this.toPosition; }

    public boolean isValid() {
        if (fromPosition.getRow() == toPosition.getRow()) {
            if (fromPosition.getColumn() == toPosition.getColumn()) return false;
        }
        return true;
    }
}
