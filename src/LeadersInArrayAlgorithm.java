/**
 * Created by bahubali.n on 30/12/16.
 */
public class LeadersInArrayAlgorithm {

    public static void main(String[] args) throws Exception{
        int[] inputArray = {16, 11, 12, 13, 5, 2};
        int sizeOfArray = inputArray.length;
        int end, maxElement = 0;

        for (end = sizeOfArray - 1; end >=0; end--){
            if (end == sizeOfArray - 1) {
                maxElement = inputArray[end];
                System.out.println(maxElement);
            }
            else {
                if (inputArray[end] > maxElement) {
                    maxElement = inputArray[end];
                    System.out.println(maxElement);
                }
            }
        }

    }
}
