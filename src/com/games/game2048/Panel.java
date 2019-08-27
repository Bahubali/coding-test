package com.games.game2048;

public class Panel {

    private int number;
    private Position position;

    Panel(Position position) {
        this.position = position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() { return this.number; }
}
