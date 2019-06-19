package com.games.chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bahubali.n on 16/06/19.
 */
public class ChessBoard extends Board {

    private List<Player> players = new ArrayList<>();

    private final Panel[][] grid = new Panel[this.rows][this.columns];
    public ChessBoard(int rows, int columns) {
        super(rows, columns);
    }
    @Override
    public void initializeBoard() {
        for (int i = 0; i < this.rows; i++) {
            Panel previousPanel = (i > 0)? grid[i-1][0] : grid[i][0];
            for (int j = 0; j < this.columns; j++) {
                if (previousPanel instanceof WhitePanel)
                    grid[i][j] = new BlackPanel(new Position(i, j));
                else
                    grid[i][j] = new WhitePanel(new Position(i, j));
                previousPanel = grid[i][j];
            }
        }
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.getPieces().stream().forEach(piece -> {
            Panel panel = grid[piece.getPosition().getRow()][piece.getPosition().getColumn()];
            panel.setPiece(piece);
        });
    }

    public void makeMove(final Move move) {
        Player player = move.getPlayer();

    }
    public void printBoard() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                Panel panel = grid[i][j];
                if (panel.getPiece() != null)
                    System.out.print(panel.getPiece().getName()+"  ");
                else {
                    System.out.print("--  ");
                }
            }
            System.out.println();
            System.out.println();
        }
    }
}
