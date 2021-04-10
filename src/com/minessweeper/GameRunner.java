package com.minessweeper;

import com.coffee.Ingredient;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class GameRunner {

    public static void main(String[] args) {
        MinesGrid minesGrid = new MinesGrid(10, 10);
        minesGrid.initBoard();
//        minesGrid.reveal(0, 2);
//        minesGrid.print();
//        System.out.println("***************");
//        minesGrid.reveal(3, 0);
//        minesGrid.print();
//        System.out.println("***************");
//        minesGrid.reveal(1, 4);
//        minesGrid.print();
        Scanner scanner = new Scanner(System.in);
        Integer numOfMines = scanner.nextInt();
        minesGrid.placeMines(numOfMines);
        minesGrid.print();
        try {
            while (scanner.hasNext()) {
                String line = scanner.next();
                if (line.length() < 1) break;
                int[] result = Arrays.stream(line.split(","))
                        .mapToInt(num -> Integer.parseInt(num)).toArray();

                minesGrid.reveal(result[0], result[1]);
                minesGrid.print();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
