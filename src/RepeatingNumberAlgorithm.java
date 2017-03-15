/**
 * Created by bahubali.n on 03/01/17.
 */
public class RepeatingNumberAlgorithm {
    public static void main(String[] args) throws Exception{
        int[] inputArray = {4, 4, 2, 2, 5, 3, 1};
        int sizeOfArray = inputArray.length;

        int start = 1;
        int prevElement = inputArray[0];
        int xorElement = inputArray[0];
        while (start < sizeOfArray) {
            xorElement = xorElement ^ inputArray[start];
            if (xorElement == prevElement || xorElement == 0) {
                System.out.println("Repeating number is " + inputArray[start]);
            }

            prevElement = inputArray[start];
            start++;
        }
    }
}
