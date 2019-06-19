package com.games.chess;

/**
 * Created by bahubali.n on 16/06/19.
 */
public class Move {

    private Player player;

    private Position position;

    Move(final Player player, final Position position) {
        this.player = player;
        this.position = position;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Position getPosition() {
        return this.position;
    }
}
