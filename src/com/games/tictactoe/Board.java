package com.games.tictactoe;

/**
 * Created by bahubali.n on 17/03/19.
 */
public class Board {

    public static final int BOARD_SIZE = 3;
    private int no_of_moves = 0;
    private Player winner = null;
    private final Player[][] grid = new Player[BOARD_SIZE][BOARD_SIZE];

    public Board makeMove(final Move move) {
        if (winner == null) {
            grid[move.row][move.column] = move.player;
            no_of_moves++;
            if (no_of_moves > ((BOARD_SIZE*BOARD_SIZE)/2)) {
                if (isWinner(move)) {
                    winner = move.player;
                }
            }
        }
        return this;
    }

    public boolean isWinner(final Move move) {
        boolean isWinner = false;
        for (int i = 0; i < BOARD_SIZE; i++) {
            int val = 0;
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (grid[i][j] != move.player) break;
                else {
                    val++;
                }
            }
            if (val == BOARD_SIZE) isWinner = true;
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            int val = 0;
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (grid[j][i] != move.player) break;
                else {
                    val++;
                }
            }
            if (val == BOARD_SIZE) isWinner = true;
        }

        return isWinner;
    }

    public void whoWon() {
        if (winner == null) System.out.println("No body won yet!!");
        else System.out.println("Player : "+winner+" has own");
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                stringBuilder.append(grid[i][j] == null ? "-" : grid[i][j]).append(' ');
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
