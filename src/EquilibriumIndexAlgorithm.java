/**
 * Created by bahubali.n on 05/01/17.
 */
public class EquilibriumIndexAlgorithm {

    public static void main(String[] args) throws Exception {
        int[] inputArray = {-7, 1, 5, 2, -4, 3, 0};
        int sizeOfArray = inputArray.length;

        int[] leftArray = new int[sizeOfArray];
        int[] rightArray = new int[sizeOfArray];

        leftArray[0] = 0; rightArray[sizeOfArray - 1] = 0;
        for (int i = 1; i < sizeOfArray; i++)
            leftArray[i] = inputArray[i-1] + leftArray[i-1];

        for (int j = sizeOfArray - 2; j >= 0; j--)
            rightArray[j] = inputArray[j+1] + rightArray[j+1];

        EquilibriumIndexAlgorithm.findEquilibriumIndex(leftArray, rightArray);
    }

    static void findEquilibriumIndex(int[] leftArray, int[] rightArray) {
        for (int i = 0; i < leftArray.length; i++) {
            if (leftArray[i] == rightArray[i]) System.out.println("Equilibrium Index : "+i);
        }
    }
}
