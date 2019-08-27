/**
 * Created by bahubali.n on 03/01/17.
 */
public class RepeatingNumberAlgorithm {
    public static void main(String[] args) throws Exception{
        int[] inputArray = {4, 4, 2, 2, 5, 3, 1, 1, 8, 9, 9, 0, 15};
        int sizeOfArray = inputArray.length;

        int start = 1;
        int xorElement = inputArray[0];
        while (start < sizeOfArray) {
            xorElement = xorElement ^ inputArray[start];
            if (xorElement == 0) {
                System.out.println("Repeating number is " + inputArray[start]);
            }

            xorElement = inputArray[start];
            start++;
        }
    }
}
