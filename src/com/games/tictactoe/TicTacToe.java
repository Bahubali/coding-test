package com.games.tictactoe;

/**
 * Created by bahubali.n on 17/03/19.
 */
public class TicTacToe {

    public static void main(String[] args) {
        final Board board = new Board();
        board.makeMove(new Move(1, 1, Player.X));
        board.makeMove(new Move(1, 2, Player.O));
        board.makeMove(new Move(2, 0, Player.X));
        board.makeMove(new Move(2, 2, Player.O));
        board.makeMove(new Move(2, 1, Player.X));
        board.makeMove(new Move(0, 2, Player.O));
        board.makeMove(new Move(2, 2, Player.X));
        board.whoWon();
        System.out.println(board);
    }
}
