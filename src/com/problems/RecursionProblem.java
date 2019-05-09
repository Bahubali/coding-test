package com.problems;

/**
 * Created by bahubali.n on 21/01/19.
 */
public class RecursionProblem {
    public static void main(String []args){
        System.out.println("Power of :"+powerOf(6, 2));
        System.out.println("Binary of num 43:");
        printBinary(43);
    }

    public static int powerOf(int base, int toExp) {
        if (toExp == 0) {
            return 1;
        } else {
            return base * powerOf(base, toExp - 1);
        }
    }

    public static void printBinary(int num) {
        if (num < 2) {
            //base case
            System.out.print(num+" ");
        } else {
            //recursive case
            int quotient = num / 2;
            int reminder = num % 2;
            printBinary(quotient);
            System.out.print(reminder+" ");
        }
    }
}
