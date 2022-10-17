package com.Sorting;

import java.util.Arrays;;

public class SortingProblems {
    public static int solve(int[] A) {
        int minCost = 0;
        int n = A.length;

        if(n == 1){
            return A[0];
        }

        //sort the integer array in descending order
        // Arrays.sort(A, new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer o1, Integer o2) {
        //         return o2.compareTo(o1);
        //     }
        // });

        System.out.println(Arrays.toString(A));
        return 0;
    }
    public static void main(String[] args) {
        int arr[] = new int[] {10, 0, 8};
        int res = solve(arr);
    }
}
