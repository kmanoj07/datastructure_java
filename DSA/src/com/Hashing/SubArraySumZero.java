package com.Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class SubArraySumZero {

    public static boolean containsSubArrwithSumZero(ArrayList<Integer> A) {
        int n = A.size();

        int[] PFsum = new int[n];
        PFsum[0] = A.get(0);
        for (int i = 1; i < n; i++) {
            PFsum[i] = PFsum[i - 1] + A.get(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = -1;
                if (i == 0) {
                    sum = PFsum[j];
                } else {
                    sum = PFsum[j] - PFsum[i - 1];
                }
                if (sum == 0) {
                    return true;
                }
            } 
        }

        return false;

    }

    public static int containsSubArrwithSumZeroOpt(ArrayList<Integer> A) {
        int n = A.size();
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int sum = 0;
        mp.put(-1, 0);

        for (int i = 0; i < n; i++) {
            sum = sum + A.get(i);
            if (mp.containsKey(sum) && mp.get(sum) == 0) {
                return 1;
            } else {
                mp.put(sum, i);
            }
        }

        return 0;

    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>() {
            {
                add(-1);
                add(-1);
            }
        };
        System.out.println(containsSubArrwithSumZeroOpt(A));
    }
}
