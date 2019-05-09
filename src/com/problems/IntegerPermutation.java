package com.problems;

/**
 * Created by bahubali.n on 08/01/19.
 */
public class IntegerPermutation {

    public static void main(String[] args) {

        char[] charArray = "ABCD".toCharArray();
        char[] resultArray = new char[charArray.length];
        IntegerPermutation.findPermutation(charArray, resultArray, charArray.length, 23);
        for (int i = 0; i < resultArray.length; i++)
            System.out.print(resultArray[i]);
        System.out.println();

    }

    public static char[] findPermutation(char[] perm, char[] result,int level, int position) {

        if (position <= 1) {
            if (position == 1) {
                for (int i = 0; i < perm.length; i++) {
                    if (perm[i] != '@' && level > 0) {
                        result[perm.length - level] = perm[i];
                        level--;
                    }
                }
                return result;
            } else {
                for (int i = perm.length-1; i >= 0; i--) {
                    if (perm[i] != '@' && level > 0) {
                        result[perm.length - level] = perm[i];
                        level--;
                    }
                }
                return result;
            }
        }

        int eachLevelPermutation = 0, currentPosition = 0;
        eachLevelPermutation = noOfPermutations(level - 1);
        currentPosition = position / eachLevelPermutation;
        position = position % eachLevelPermutation;
        currentPosition = (position <= 0)? currentPosition - 1: currentPosition;

        currentPosition = getCurrentPosition(perm, currentPosition);
        result[perm.length - level] = perm[currentPosition];
        perm[currentPosition] = '@';
        findPermutation(perm, result, level-1, position);

        return result;
    }

    private static int noOfPermutations(int level) {
        if (level == 0)
            return 1;
        return level * noOfPermutations(level - 1);
    }

    private static int getCurrentPosition(char[] perm, int position) {
        int k = 0, count = 0;
        while (k < perm.length && count <= position) {
            if (perm[k] != '@') {
                count++;
            }
            k++;
        }
        return k-1;
    }
}
