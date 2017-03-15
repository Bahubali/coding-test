/**
 * Created by bahubali.n on 06/01/17.
 */
public class LongestIncreasingSequenceAlgorithm {

    public static void main(String[] args) throws Exception{

        int[] inputArray = {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10};
        int sizeOfArray = inputArray.length;

        int[] tempArray = new int[sizeOfArray];
        tempArray[0] = 1;
        int j, maxSequenceLength;
        for (int i = 1; i < sizeOfArray; i++) {
            j = 0;
            tempArray[i] = 1;
            while (j < i) {
                if (inputArray[j] < inputArray[i]) {
                    maxSequenceLength = tempArray[j]+1;
                    if (tempArray[i] < maxSequenceLength) tempArray[i] = maxSequenceLength;
                }
                j++;
            }
        }


        for (int i = 0; i < sizeOfArray; i++)
            System.out.println(tempArray[i]);
    }
}
