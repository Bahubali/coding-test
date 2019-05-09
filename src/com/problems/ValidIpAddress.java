package com.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bahubali.n on 27/01/19.
 */
public class ValidIpAddress {

    public static void main(String[] args) {
        String ipAddress = "192168215";
        permuteAllAddresses(ipAddress, 4, ipAddress.length(), 0, new ArrayList<>());
    }

    public static void permuteAllAddresses(String ipString, int positions, int desiredSum, int sumSoFar, List<Integer> choices) {
        if (positions == 0) {
            StringBuilder ipAddress = new StringBuilder();
            int start = 0; boolean isValid = true;
            while(positions < choices.size()) {
                String partOfIp = ipString.substring(start, (choices.get(positions)+start));
                if (!isValidPart(partOfIp)) {
                    isValid = false;
                    break;
                }
                ipAddress.append(partOfIp);
                ipAddress.append(".");
                start += choices.get(positions);
                positions++;
            }
            if (isValid) System.out.println(ipAddress.substring(0, ipAddress.length() - 1));
            positions = 0;
        } else {
            for (int i = 1; i <= 3; i++) {
                // chose/explore/un-chose

                if (sumSoFar+i+1*(positions - 1) <= desiredSum &&
                        sumSoFar+i+3*(positions - 1) >= desiredSum) {
                    choices.add(i);
                    permuteAllAddresses(ipString, positions - 1, desiredSum, sumSoFar+i, choices);
                    choices.remove(choices.size() - 1);
                }
            }
        }
    }

    private static boolean isValidPart(String s) {
        if (s.length() > 3) { return false;
        } // "00", "000", "01", etc. are not valid, but "0" is valid.
        if (s.startsWith("0") && s.length() > 1) {
            return false;
        }
        int val = Integer.parseInt(s);
        return val <= 255 && val >= 0; }
}
