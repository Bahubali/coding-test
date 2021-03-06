import java.util.HashMap;
import java.util.Map;

/**
 * Created by bahubali.n on 09/02/17.
 */
public class UniqueStringAlgorithm {
    public static void main(String[] args) throws Exception{
        String inputString = "BAHUBALI".toLowerCase();
        int hashCode = inputString.hashCode();
        //System.out.println(((hashCode) ^ (hashCode >>> 16)));
        Map<String, String> phoneBook = new HashMap<String, String>();

//        int sum = 0;
//        for (int i = 0; i < inputString.length(); i++) {
//            System.out.println("Char val: "+(int)inputString.charAt(i));
//            sum ^= (int)inputString.charAt(i);
//            System.out.println("XOR of each char:"+sum);
//        }

        String inputStr = "abcdefghdbac";
        char[] chars = inputStr.toCharArray();
        Map<Character, Integer> charsMap = new HashMap<>();
        int start = 0, maxLength = 0;
        for (int i = 0; i < chars.length; i++) {
            int maxSoFar = 1;
            if (!charsMap.containsKey(chars[i])) {
                charsMap.put(chars[i], i);
            } else {
                maxSoFar = (i - start);
                start = charsMap.get(chars[i]) + 1;
                charsMap.put(chars[i], i);
            }
            maxLength = Math.max(maxLength, maxSoFar);
        }
        System.out.println("Longest substring "+maxLength);
    }
}
