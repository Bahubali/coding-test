package com.leetcode;

import java.util.Scanner;
public class CandiesToConvert {

    public static void main(String[] args) {
        //Write code here

        Scanner scanner = new Scanner(System.in);
        System.out.println("Triangle Lines:");
        int totalLinesOfTriangle = Integer.parseInt(scanner.nextLine());
        int possibleSquareMatrix = totalLinesOfTriangle, minCandiesToMove = 0;;
        int[] candiesInEachLevel = new int[totalLinesOfTriangle];
        for (int i = 0; i < candiesInEachLevel.length; i++) {
            candiesInEachLevel[i] = (2 * i) + 1;
            if (candiesInEachLevel[i] < possibleSquareMatrix) {
                minCandiesToMove += (possibleSquareMatrix - candiesInEachLevel[i]);
            }
        }

        System.out.println(minCandiesToMove);
    }
}
