package com.game2048;

/**
 * Created by bahubali.n on 15/01/19.
 */
public class Tile {

    private int value;

    public Tile(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void clear() {
        this.setValue(0);
    }

    public void merge(Tile tile) {
        this.setValue(this.getValue() + tile.getValue());
    }

    public void swap(Tile tile) {
        if (tile.getValue() > 0) {
            this.setValue(tile.getValue());
            tile.clear();
        }
    }

    public boolean equal(Tile tile) {
        return (this.getValue() == tile.getValue());
    }
}
