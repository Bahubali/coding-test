package com.games.chess;

/**
 * Created by bahubali.n on 16/06/19.
 */
public class ChessGame {
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard(8, 8);
        chessBoard.initializeBoard();
        chessBoard.addPlayer(new Player("W", new Position(0, 0), new Position(1, 7)));
        chessBoard.addPlayer(new Player("B", new Position(6, 0), new Position(7, 7)));
        chessBoard.printBoard();
    }
}
