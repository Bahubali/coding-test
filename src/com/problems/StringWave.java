package com.problems;

/**
 * Created by bahubali.n on 27/01/19.
 */
public class StringWave {

    public static void main(String[] args) {
        String input = "Bahubali Nandaganv";
        char[][] waves = new char[3][input.length()];
        int position = 0, direction = 0, row = 1, column = 0;
        while (position < input.length()) {
            if (direction == 0 && row > 0) {
                waves[row][column] = input.charAt(position);
                row--;
                column++;
            } else if (direction == 0 && row == 0) {
                direction = 1;
                waves[row][column] = input.charAt(position);
                row++;
                column++;
            } else if (direction == 1 && row < 2) {
                waves[row][column] = input.charAt(position);
                row++;
                column++;
            } else if (direction == 1 && row == 2) {
                waves[row][column] = input.charAt(position);
                direction = 0;
                row--;
                column++;
            }
            position++;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < input.length(); j++) {
                System.out.print(waves[i][j]+" ");
            }
            System.out.println();
        }
    }
}
