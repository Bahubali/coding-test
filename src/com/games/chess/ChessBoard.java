package com.games.chess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bahubali.n on 16/06/19.
 */
public class ChessBoard extends Board {

    private List<Player> players = new ArrayList<>();
    private Map<String, Panel> panels = new HashMap<>();
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
                panels.put(previousPanel.getPosition().getKey(), previousPanel);
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
        if (move.isValid()) {
            Player player = move.getPlayer();
            Panel panel = panels.get(move.getFromPosition().getKey());
            Piece piece = panel.getPiece();
            if (player.getColor().equalsIgnoreCase(piece.getColor())) {
                if (piece.isValidMove(panel)) {
                    piece.setPosition(move.getToPosition());
                    panel.setPiece(null);
                    Panel newPanel = grid[move.getToPosition().getRow()][move.getToPosition().getColumn()];
                    newPanel.setPiece(piece);
                } else {
                    System.out.println("Invalid move");
                }
            } else {
                System.out.println("Invalid move");
            }
        } else {
            System.out.println("Invalid move");
        }
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
