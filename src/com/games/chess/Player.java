package com.games.chess;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bahubali.n on 16/06/19.
 */
public class Player {

    private String color = null;
    private List<Root> roots;
    private List<Knight> knights;
    private List<Bishop> bishops;
    private List<Pawn> pawns;
    private Queen queen;
    private King king;
    private List<Piece> pieces = new ArrayList<>();

    public Player(String color, Position from, Position to) {
        this.color = color;
        this.knights = new ArrayList<>();
        this.bishops = new ArrayList<>();
        this.roots = new ArrayList<>();
        this.pawns = new ArrayList<>();
        this.queen = null;
        this.king = null;
        onboardPieces(from, to);
    }

    private void onboardPieces(Position from, Position to) {
        //Add pawns
        int pawnRow = (this.color == "W")? to.getRow() : from.getRow();
        int backRow = (this.color == "W")? from.getRow() : to.getRow();
        addBishops(backRow);
        addKnights(backRow);
        addRoots(backRow);
        addKing(backRow);
        addQueen(backRow);
        for (int column = from.getColumn(); column <= to.getColumn(); column++) {
            Position position = new Position(pawnRow, column);
            Piece piece = new Pawn(color);
            piece.setPosition(position);
            addPiece(piece);
        }
    }
    public void addPiece(Piece piece) {
        if (piece instanceof King) {
            if (this.king == null) this.king = (King) piece;
        } else if (piece instanceof Queen) {
            if (this.queen == null) this.queen = (Queen) piece;
        } else if (piece instanceof Pawn) {
            if (this.pawns.size() < 8) {
                this.pawns.add((Pawn) piece);
            }
        } else if (piece instanceof Root) {
            if (this.roots.size() < 2) {
                this.roots.add((Root) piece);
            }
        } else if (piece instanceof Knight) {
            if (this.knights.size() < 2) {
                this.knights.add((Knight) piece);
            }
        } else if (piece instanceof Bishop) {
            if (this.bishops.size() < 2) {
                this.bishops.add((Bishop) piece);
            }
        }
        pieces.add(piece);
    }

    private void addBishops(int row) {
        Piece piece = new Bishop(color);
        piece.setPosition(new Position(row, 1));
        Piece piece1 = new Bishop(color);
        piece1.setPosition(new Position(row, 6));
        addPiece(piece);
        addPiece(piece1);
    }

    private void addRoots(int row) {
        Piece piece = new Root(color);
        piece.setPosition(new Position(row, 0));
        Piece piece1 = new Root(color);
        piece1.setPosition(new Position(row, 7));
        addPiece(piece);
        addPiece(piece1);
    }

    private void addKnights(int row) {
        Piece piece = new Knight(color);
        piece.setPosition(new Position(row, 2));
        Piece piece1 = new Knight(color);
        piece1.setPosition(new Position(row, 5));
        addPiece(piece);
        addPiece(piece1);
    }

    private void addKing(int row) {
        int column = (color == "W")? 3 : 4;
        Piece piece = new King(color);
        piece.setPosition(new Position(row, column));
        addPiece(piece);
    }

    private void addQueen(int row) {
        int column = (color == "W")? 4 : 3;
        Piece piece = new Queen(color);
        piece.setPosition(new Position(row, column));
        addPiece(piece);
    }

    public List<Piece> getPieces() {
        return this.pieces;
    }
}
