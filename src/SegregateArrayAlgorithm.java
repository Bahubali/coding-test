/**
 * Created by bahubali.n on 30/12/16.
 */
public class SegregateArrayAlgorithm {
    public static void main(String[] args) throws Exception{
        int[] inputArray = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1};
        int sizeOfArray = inputArray.length;
        int start = 0, end = sizeOfArray - 1;

        while (start < end) {
            if (inputArray[start] == 0) start++;
            else {
                if (inputArray[end] == 1) end--;
                else {
                    swapElements(inputArray, start, end);
                }
            }
        }

        for (int i = 0; i < inputArray.length; i++)
            System.out.println(inputArray[i]);

    }

    static void swapElements(int[] inputArray, int sIndex, int eIndex){
        int temp = inputArray[sIndex];
        inputArray[sIndex] = inputArray[eIndex];
        inputArray[eIndex] = temp;
    }
}
