package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
//        int check = 3^5;
//        System.out.println(check);
        System.out.println("Is Valid Sudoku? "+isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        if (board.length != 9) return false;
        else {
            for (int i = 0; i < board.length; i++) {
                if (!isValidRow(board, i)) return false;
                else if (!isValidColumn(board, i)) return false;
            }
            int gridCount = 0, totalGrid = 9;
            while (gridCount < totalGrid) {
                int row = ((gridCount*3)/9)*3;
                int column = (gridCount*3) % 9;
                if (!isValidGrid(board, row, column)) return false;
                gridCount++;
            }
            return true;
        }
    }

    public static boolean isValidRow(char[][] board, int row) {
        Map<Character, Integer> characterMap = new HashMap<>();
        for (int column = 0; column < board.length; column++) {
            if ((board[row][column] != '.')) {
                if (characterMap.get(board[row][column]) != null) return false;
                characterMap.put((char) board[row][column], 1);
            }
        }
        return true;
    }

    public static boolean isValidColumn(char[][] board, int column) {
        Map<Character, Integer> characterMap = new HashMap<>();
        for (int row = 0; row < board.length; row++) {
            if ((board[row][column] != '.')) {
                if (characterMap.get(board[row][column]) != null) return false;
                characterMap.put((char) board[row][column], 1);
            }
        }
        return true;
    }

    public static boolean isValidGrid(char[][] board, int row, int column) {
        Map<Character, Integer> characterMap = new HashMap<>();
        for (int i = row; i < row+3; i++) {
            for (int j = column; j < column+3; j++) {
                System.out.print(i+":"+j+",");
                if ((board[i][j] != '.')) {
                    if (characterMap.get(board[i][j]) != null) return false;
                    characterMap.put((char) board[i][j], 1);
                }
            }
        }
        return true;
    }
}
