/**
 * Created by bahubali.n on 11/01/17.
 */

public class MaxMoneyCollectedAlgorithm {

    public static void main(String[] args) throws Exception{
        int n = 15; // No of students, each donates to value of his reference
        int k = 21; // Sum that should not equal of this
        System.out.println(maxMoney(n, k));
    }

    static int maxMoney(int n, long k) {
        int moneyCollected = 0, minElement = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++){
            if (i < minElement) minElement = i;
            moneyCollected += i;
            if (moneyCollected == k)
                moneyCollected -= minElement;
        }
        return moneyCollected;
    }
}
