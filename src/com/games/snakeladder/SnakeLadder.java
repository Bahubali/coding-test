package com.games.snakeladder;

/**
 * Created by bahubali.n on 27/05/19.
 */
public class SnakeLadder {

    public static void main(String[] args) throws Exception {
        Board board = new Board();
        Player player1 = new Player("A", board.getPanel(1));
        Player player2 = new Player("B", board.getPanel(1));
        board.addPlayer(player1);
        board.addPlayer(player2);
        board.addSnake(new Snake(board.getPanel(21), board.getPanel(9)));

        Player current = player1;
        while (!board.hasWinner()) {
            int dice = SnakeLadder.rollDice();
            board.makeMove(current, dice);
            System.out.println("Player "+current.getName()+ " in panel : "+current.getCurrentPanel().getNumber());
            current = (current.getName() == "A")? player2 : player1;
        }
        System.out.println("Board initialization completed"+board.winner.getName());
    }

    public static int rollDice(){
        return (int)(Math.random()*6) + 1;
    }
}
