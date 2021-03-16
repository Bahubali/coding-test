package com.coding;

import lombok.Data;

@Data
public abstract class Board {
    
    private int rows;
    private int columns;
    protected Tile[][] tiles;
    Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.tiles = new Tile[rows][columns];
    }
    protected abstract void initializeBoard();
    
    protected int getSize() {
        return this.tiles.length;
    }
    
    protected boolean hasEmptyTiles() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (tiles[i][j].getValue() == 0) {
                    return true;
                }
            }
        }
        return false;
    }
        
}
