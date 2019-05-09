package com.problems;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bahubali.n on 25/12/18.
 */
public class AdvancingThroughArray {

    public static void main(String[] args) {
        List<Integer> inputArray = Arrays.asList(2, 3, 1, 1, 2, 4, 2, 0, 1, 1);

        //int prevStepIndex = 0, prevStepAdvance = 0, furthestSoFor = 0;
        int minJumps = 0;
        boolean reachedEnd = false;
        for (int i = 0; i < inputArray.size() - 1;) {
            int maxAdvance = 0, nextAdvance = 0, nextStep = 0;
            int k = i + inputArray.get(i);
            for (int j = i + 1; j <= k; j++) {
                if (inputArray.get(j) != 0) {
                    nextAdvance = j + inputArray.get(j);
                    if (maxAdvance < nextAdvance) {
                        maxAdvance = nextAdvance;
                        nextStep = j;
                    }
                    if (maxAdvance >= inputArray.size()-1) {
                        reachedEnd = true;
                        break;
                    };
                }
            }
            if (nextStep > 0) {
                minJumps++;
                i = nextStep;
            } else {
                System.out.println("Dead loop");
                break;
            }
            if (reachedEnd) {
                minJumps++;
                System.out.println("Minimum Jumps: "+minJumps);
                break;
            }
        }
    }
}