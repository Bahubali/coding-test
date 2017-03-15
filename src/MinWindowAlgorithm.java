import java.util.*;

/**
 * Created by bahubali.n on 08/02/17.
 */
public class MinWindowAlgorithm {

    public static final class MinWindow {

        private int startIndex;

        public MinWindow() {

        }
        public int getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public int getWindowLength() {
            return windowLength;
        }

        public void setWindowLength(int windowLength) {
            this.windowLength = windowLength;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public void setEndIndex(int endIndex) {
            this.endIndex = endIndex;
        }

        private int endIndex;
        private int windowLength;
    }

    public static void main(String[] args) throws Exception{
        String input = "ACBDGHEFBACCABB";
        String substring = "ABB";
        int sizeOfArray = input.length();
        Map<Character, Integer> subMap = new HashMap<Character, Integer>();
        for (int i = 0; i < substring.length(); i++) {
            char c = substring.charAt(i);
            if(subMap.containsKey(c)){
                subMap.put(c,subMap.get(c)+1);
            }else{
                subMap.put(c,1);
            }
        }

        MinWindow minWindow = new MinWindow();
        Map<Character, ArrayList<Integer>> target = new HashMap<Character, ArrayList<Integer>>();
        for (int j = 0; j < sizeOfArray; j++) {
            char c = input.charAt(j);
            if (subMap.containsKey(c)) {
                if (target.isEmpty()) minWindow.setStartIndex(j);
                ArrayList<Integer> list = new ArrayList<Integer>();
                if(target.containsKey(c)) {
                    list = target.get(c);
                    list.add(j);
                    target.put(c, list);
                } else {
                    list.add(j);
                    target.put(c, list);
                }
            }
            if (target.size() == subMap.size()) {
                Object[] list = target.values().toArray();
                minWindow.setEndIndex(j);
                int window = (minWindow.getEndIndex() - minWindow.getStartIndex()) + 1;
                minWindow.setWindowLength(window);
                target.clear();
            }
        }

    }

    public static boolean isSubstring(char[] inputString, int start, int end, String substring){
        boolean isStringContains = false;

        char[] subArray = Arrays.copyOfRange(inputString, start, end);
        if (subArray.toString().contentEquals(substring)) isStringContains = true;
        return isStringContains;
    }

    public static void keepItForFuture() {
        String input = "ACBDGHEFBACCABB";
        char[] inputCharArray = input.toCharArray();
        String substring = "ABB";
        int sizeOfArray = inputCharArray.length;
        int start = 0, end = substring.length();
        int minWindow = Integer.MAX_VALUE;
        while (end < sizeOfArray) {
            if(isSubstring(inputCharArray, start, end, substring)) {
                int window = (end - start) + 1;
                if (window < minWindow) minWindow = window;
                start++;
            } else {
                end++;
            }

            if (minWindow == substring.length()) return;
        }
        System.out.println("Minimum window of substring :"+minWindow);
    }
}
