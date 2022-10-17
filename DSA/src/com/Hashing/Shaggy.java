package com.Hashing;

import java.util.HashMap;
import java.util.ArrayList;

public class Shaggy {

    public static int firstRepeatingElement(ArrayList<Integer> A) {
        int n = A.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(A.get(i))) {
                map.put(A.get(i), map.get(A.get(i)) + 1);
            } else {
                map.put(A.get(i), 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (map.get(A.get(i)) > 1) {
                return A.get(i);
            }
        }

        return -1;
    }

    public static int shaggyDistance(ArrayList<Integer> A) {
        int n = A.size();
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A.get(i) == A.get(i)) {
                    int ms = Math.abs(i - j);
                    if (ms < minDis) {
                        minDis = ms;
                    }
                }
            }
        }
        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }

    public static int shaggyDistanceOpt(ArrayList<Integer> A) {
        int n = A.size();
        int minDis = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            if (!map.containsKey(A.get(i))) {
                map.put(A.get(i), i);
            } else {
                int j = map.get(A.get(i));
                if (minDis > (i - j)) {
                    minDis = i - j;
                }
            }
        }
        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>() {
            { 
                add(7);
                add(1);
                add(3);
                add(4);
                add(1);
                add(7);
            }
        };
        System.out.println(shaggyDistanceOpt(A));
    }
}
