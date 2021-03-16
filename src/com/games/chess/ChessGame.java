package com.games.chess;

/**
 * Created by bahubali.n on 16/06/19.
 */
public class ChessGame {
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard(8, 8);
        chessBoard.initializeBoard();
        Player white = new Player("W", new Position(0, 0), new Position(1, 7));
        chessBoard.addPlayer(white);
        Player black = new Player("B", new Position(6, 0), new Position(7, 7));
        chessBoard.addPlayer(black);
        chessBoard.printBoard();

        chessBoard.makeMove(new Move(white, new Position(1, 3), new Position(2, 3)));
        chessBoard.makeMove(new Move(white, new Position(2, 3), new Position(3, 3)));
        System.out.println("After first move");
        chessBoard.printBoard();

    }
}
