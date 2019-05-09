package com.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by bahubali.n on 03/01/19.
 */
public class EnumeratePrimeNumbers {

    public static void main(String[] args) {
        int n = 100;
        List<Boolean> primeList = new ArrayList<>(Collections.nCopies(n+1, true));
        primeList.set(0, false);
        primeList.set(1, false);

        for (int i = 0; i < primeList.size(); ++i) {
            if (primeList.get(i)) {
                int j = 2;
                while ((i*j) <= n) {
                    primeList.set(i * j, false);
                    j++;
                }
                System.out.println(i);
            }
        }
    }
}
