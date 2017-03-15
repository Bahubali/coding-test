/**
 * Created by bahubali.n on 02/01/17.
 */
public class MaxDifferenceAlgorithm {
    public static void main(String[] args) throws Exception{
        int[] inputArray = {4, 6, 13, 10, 2, 12, 11};
        int sizeOfArray = inputArray.length;

        System.out.println(MaxDifferenceAlgorithm.findMaxDifference(inputArray, sizeOfArray));
    }

    static int findMaxDifference(int[] inputArray, int size) {
        int minElement = inputArray[0], maxDifference = 0;
        for (int i = 0; i < size; i++) {
            if (minElement < inputArray[i]) {
                int diff = difference(inputArray[i], minElement);
                if (diff > maxDifference) maxDifference = diff;

            } else {
                minElement = inputArray[i];
            }
        }
        return maxDifference;
    }

    static int difference(int a, int b) {
        return (a > b)? a - b : 0;
    }
}
