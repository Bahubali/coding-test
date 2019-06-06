package com.games.snakeladder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bahubali.n on 27/05/19.
 */
public class Board {

    public static final int BOARD_SIZE = 10;
    public Player winner = null;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private List<Player> players;
    public final Panel[][] grid = new Panel[BOARD_SIZE][BOARD_SIZE];

    public Board() {
        this.players = new ArrayList<>();
        this.ladders =  new ArrayList<>();
        this.snakes = new ArrayList<>();
        initializeBoard();
    }

    private void initializeBoard() {
        int count = 100, direction = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (direction == 0) {
                for (int j = 0; j< BOARD_SIZE; j++) {
                    Panel panel = new Panel(count);
                    grid[i][j] = panel;
                    count--;
                }
            } else if (direction == 1) {
                for (int j = BOARD_SIZE - 1; j >= 0; j--) {
                    Panel panel = new Panel(count);
                    grid[i][j] = panel;
                    count--;
                }
            }
            direction = (direction+1)%2;
        }
    }

    public void makeMove(Player player, int position) {
        if (winner == null) {
            Position newPosition = getNewPosition(player.getCurrentPosition(), position);
            Panel panel = grid[newPosition.row][newPosition.column];
            Snake snakeBite = checkIfSnakeBite(newPosition);
            if (snakeBite != null) {
                newPosition = snakeBite.getTail();
            }
            Ladder ladder = checkIfLadderFound(newPosition);
            if (ladder != null) {
                newPosition = ladder.getTop();
            }
            player.setCurrentPosition(newPosition);
            panel.addPlayer(player);
            if (panel.getNumber() == 100) winner = player;
        }
    }

    public void addPlayer(Player player) {
        if (players != null) {
            players.add(player);
        }
    }

    public void addSnake(Snake snake) {
        if (snakes != null) {
            snakes.add(snake);
        }
    }

    public void addLadder(Ladder ladder) {
        if (ladders != null) {
            ladders.add(ladder);
        }
    }

    private Position getNewPosition(Position currentPosition, int steps) {
        int direction = ((currentPosition.row % 2) == 0)? 1 : 0;
        int playerAtNumber = grid[currentPosition.row][currentPosition.column].getNumber();
        int newNumber = playerAtNumber + steps;
        Position newPosition = null;
        for (int i = currentPosition.row; i < BOARD_SIZE; i++) {
            if (direction == 0) {
                for (int j = currentPosition.column; j < BOARD_SIZE; j++) {
                    if (grid[i][j].getNumber() == newNumber) {
                        newPosition = new Position(i, j);
                        break;
                    }
                }
            } else if (direction == 1) {
                for (int j = currentPosition.column; j >= 0; j--) {
                    if (grid[i][j].getNumber() == newNumber) {
                        newPosition = new Position(i, j);
                        break;
                    }
                }
            }
            direction = (direction+1)%2;
            if (playerAtNumber == newNumber) break;
        }
        return newPosition;
    }

    private Snake checkIfSnakeBite(Position position) {
        Snake snakeBite = null;
        for (Snake snake : snakes) {
            Position snakeHead = snake.getHead();
            if (snakeHead.row == position.row && snakeHead.column == position.column) {
                snakeBite = snake;
                break;
            }
        }
        return snakeBite;
    }

    private Ladder checkIfLadderFound(Position position) {
        Ladder ladderFound = null;
        for (Ladder ladder : ladders) {
            Position ladderBottom = ladder.getBottom();
            if (ladderBottom.row == position.row && ladderBottom.column == position.column) {
                ladderFound = ladder;
                break;
            }
        }
        return ladderFound;
    }

    public boolean hasWon() {
        return (winner == null)? false : true;
    }
}
