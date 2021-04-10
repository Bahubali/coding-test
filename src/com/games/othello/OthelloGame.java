package com.games.othello;

import com.games.chess.Move;

import java.util.ArrayList;
import java.util.List;

public class OthelloGame {

    private List<Player> players;
    private Board board;
    private static int ROWS = 10;
    private static int COLUMNS = 10;
    private static OthelloGame _instance;
    private OthelloGame() {
        this.board = new Board(ROWS, COLUMNS);
        this.players = new ArrayList<>();
        this.players.add(new Player(Color.WHITE));
        this.players.add(new Player(Color.BLACK));
    }
    public static OthelloGame getInstance() {
        if (_instance == null) {
            _instance = new OthelloGame();
        }
        return _instance;
    }

    public void makeMove(int r, int c, Player player) {
        this.board.placePiece(r, c, player.getColor());
    }
    public Board getBoard() {
        return this.board;
    }

    public static void main(String[] args) {
        OthelloGame game = OthelloGame.getInstance();
        game.makeMove(6, 4, game.players.get(0));
        game.makeMove(6, 5, game.players.get(1));
        game.makeMove(5, 6, game.players.get(0));
        game.makeMove(6, 3, game.players.get(1));
        game.getBoard().print();
    }
}
