package com.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by bahubali.n on 21/12/18.
 */
public class DutchFlag {

    public static enum Color { RED, WHITE, BLUE }

    public static void dutchFlagPartition(int pivotIndex, List<Color> A) {
        Color pivot = A.get(pivotIndex);
        // First pass: group elements smaller than pivot.
        int small = 0, large = A.size() - 1;

        for (int j = small + 1; j < A.size(); j++) {
            if (A.get(j).ordinal() < pivot.ordinal()) {
                Collections.swap(A, small++, j);
            }
        }

        for (int j = large - 1; j >= small; j--) {
            if (A.get(j).ordinal() > pivot.ordinal()) {
                Collections.swap(A, large--, j);
            }
        }

//        for (int i = 0; i < A.size(); ++i) {
//            // Look for a smaller element.
//            for (int j = i + 1; j < A.size(); ++j) {
//                if (A.get(j).ordinal() < pivot.ordinal()) {
//                    Collections.swap(A, i, j);
//                    break;
//                }
//            }
//        }
//        //pivot = A.get(0);
//        // Second pass: group elements larger than pivot.
//        for (int i = A.size() - 1; i >= 0 && A.get(i).ordinal() >= pivot.ordinal(); --i)
//        { // Look for a larger element. Stop when we reach an element less // than pivot, since first pass has moved them to the start of A.
//            for (int j = i - 1; j >= 0 && A.get(j).ordinal() >= pivot.ordinal(); --j) {
//                if (A.get(j).ordinal() > pivot.ordinal()) {
//                    Collections.swap(A, i, j);
//                    break;
//                }
//            }
//        }
    }

    public static void dutchFlagPartitionModified(int pivotIndex, List<Color> A) {
        Color pivot = A.get(pivotIndex);
        // First pass: group elements smaller than pivot.
        int smaller = 0, equal = 0, larger = A.size();

        while (equal < larger) {

        }
    }



    public static void main(String[] args) {
        List<Color> colors = Arrays.asList(Color.BLUE, Color.RED, Color.RED, Color.RED, Color.WHITE, Color.RED,Color.WHITE, Color.BLUE, Color.WHITE, Color.RED, Color.BLUE, Color.WHITE);
        //List<Integer> inputArray = Arrays.asList(1, 9, 9);
        DutchFlag.dutchFlagPartition(1, colors);
        colors.stream().forEach(color -> System.out.println(color.ordinal()));
    }
}
