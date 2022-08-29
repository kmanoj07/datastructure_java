package com.Hashing;

import java.util.HashMap;
import java.util.ArrayList;

public class HashingProblem {

    public static int[] cmnEle(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;

        HashMap<Integer, Integer> mapA = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> mapB = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            if (mapA.containsKey(A[i])) {
                mapA.put(A[i], mapA.get(A[i]) + 1);
            } else {
                mapA.put(A[i], 1);
            }
        }

        for (int i = 0; i < m; i++) {
            if (mapB.containsKey(B[i])) {
                mapB.put(B[i], mapB.get(B[i]) + 1);
            } else {
                mapB.put(B[i], 1);
            }  
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();

        for (int key : mapA.keySet()) {
            int valueA = mapA.get(key).intValue();
            if (mapB.containsKey(key)) {
                int valueB = mapB.get(key).intValue();
                if (valueA == valueB) {
                    for (int i = 0; i < valueA; i++) {
                        ans.add(key);
                    }
                } else {
                    ans.add(key);
                }
            }
        }

        int[] res = new int[ans.size()];
        printArrayList(ans);
        return null;
    }

    public static void printArrayList(ArrayList<Integer> A) {
        for (int i = 0; i < A.size(); i++) {
            System.out.print(A.get(i) + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 2, 1 };
        int[] B = { 2, 3, 1, 2 };
        cmnEle(A, B);
    }
}
