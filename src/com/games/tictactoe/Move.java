package com.games.tictactoe;

/**
 * Created by bahubali.n on 17/03/19.
 */
public class Move {
    final int row, column;
    final Player player;

    public Move(final int row, final int column, final Player player) {
        this.row = row;
        this.column = column;
        this.player = player;
    }
}

enum Player {
    X, O
}
