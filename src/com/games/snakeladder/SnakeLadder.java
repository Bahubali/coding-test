package com.games.snakeladder;

/**
 * Created by bahubali.n on 27/05/19.
 */
public class SnakeLadder {

    public static void main(String[] args) {
        Board board = new Board();
        Player player1 = new Player("A");
        Player player2 = new Player("B");
        board.addPlayer(player1);
        board.addPlayer(player2);
        board.addSnake(new Snake(new Position(5, 8), new Position(8, 9)));

        Player current = player1;
        while (!board.hasWon()) {
            int dice = SnakeLadder.rollDice();
            System.out.println("Dice:"+dice);
            board.makeMove(current, dice);
            System.out.println("Player "+current.getName()+": position "+board.grid[current.getCurrentPosition().row][current.getCurrentPosition().column].getNumber());
            current = (current.getName() == "A")? player2 : player1;
        }
        System.out.println("Board initialization completed"+board.winner.getName());
    }

    public static int rollDice(){
        return (int)(Math.random()*6) + 1;
    }
}
