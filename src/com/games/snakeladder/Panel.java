package com.games.snakeladder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bahubali.n on 27/05/19.
 */
public class Panel {
    private int number;
    private Snake snake;
    private Ladder ladder;
    private final Position position;
    Map<String, Player> players;

    public Panel(int panelNumber, Position position) {
        this.number = panelNumber;
        this.position = position;
        this.snake = null;
        this.ladder = null;
        this.players = new HashMap<>();
    }

    public int getNumber() {
        return this.number;
    }

    public Position getPosition() { return this.position; }

    public void addPlayer(Player player) {
        if (!players.containsKey(player.getName())) {
            players.put(player.getName(), player);
        }
    }

    public void addSnake(Snake snake) throws Exception {
        if (this.ladder != null)
            throw new Exception("Panel has ladder, wrong entry");
        if (this != snake.getHeadIn()) {
            throw new Exception("Invalid ladder to panel");
        }

        this.snake = snake;
    }

    public void addLadder(Ladder ladder) throws Exception {
        if (this.snake != null)
            throw new Exception("Panel has snake, wrong entry");
        if (this != ladder.getBottom()) {
            throw new Exception("Invalid ladder to panel");
        }

        this.ladder = ladder;
    }

    public boolean hasSnake() {
        return (this.snake != null)? true : false;
    }

    public boolean hasLadder() {
        return (this.ladder != null)? true : false;
    }

    public Snake getSnake() { return this.snake; }

    public Ladder getLadder() { return this.ladder; }
}
