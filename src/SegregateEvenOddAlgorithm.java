/**
 * Created by bahubali.n on 04/01/17.
 */
public class SegregateEvenOddAlgorithm {


    public static void main(String[] args) throws Exception{

        int[] inputArray = {12, 34, 45, 9, 8, 90, 3};
        int sizeOfArray = inputArray.length;

        int start = 0, end = sizeOfArray - 1; //Initialize start and end pointers

        while (start < end) {
            if (inputArray[start] % 2 == 0) start++; //Move to next, until odd number occur
            else {
                if (inputArray[end] % 2 != 0) end--;
                else {
                    swapArrayElements(inputArray, start, end);
                    start++;
                    end--;
                }
            }
        }

        for (int i = 0; i < sizeOfArray; i++)
            System.out.println(inputArray[i]);

    }

    static void swapArrayElements(int[] inputArray, int sIndex, int eIndex) {
        int temp = inputArray[sIndex];
        inputArray[sIndex] = inputArray[eIndex];
        inputArray[eIndex] = temp;
    }
}
