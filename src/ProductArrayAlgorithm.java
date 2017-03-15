/**
 * Created by bahubali.n on 02/01/17.
 */
public class ProductArrayAlgorithm {

    public static void main(String[] args) throws Exception{
        int[] inputArray = {10, 3, 5, 6, 2};
        int sizeOfArray = inputArray.length;

        int[] productArray = new int[sizeOfArray];
        int[] leftArray = new int[sizeOfArray];
        int[] rightArray = new int[sizeOfArray];

        leftArray[0] = 1;
        rightArray[sizeOfArray-1] = 1;

        for (int i = 1; i < sizeOfArray; i++){
            leftArray[i] = inputArray[i-1] * leftArray[i-1];
        }
        for (int j = sizeOfArray-2; j >= 0; j--) {
            rightArray[j] = inputArray[j+1]*rightArray[j+1];
        }

        for (int k = 0; k <sizeOfArray; k++)
            productArray[k] = leftArray[k]*rightArray[k];

        for (int i = 0; i < productArray.length; i++)
            System.out.println(productArray[i]);
    }
}
