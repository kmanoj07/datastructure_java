package com.Array.InterviewProblems;

public class Christmas {
    public static int minCost(int[] A, int[] B) 
    {
        int An = A.length;
        int Bn = B.length;
        int minCost = Integer.MAX_VALUE;
        if(Bn == 3) {
            minCost = B[0] + B[1] + B[2];
            return minCost;
        }
        for (int i=0;i<Bn;i++) {
            int sum = B[i];
            int s = 1;
            int k = 2; // s + k total 3 tree pick
            int e = k;
            while (e < Bn) {
                int totalCost = sum + B[s] + B[e];
                if(totalCost < minCost) {
                    minCost = totalCost;
                }
                s++;
                e++;
            }
        }
        return minCost; 
    }
    public static void main(String[] args) {
        // int[] A  = {1,6,4,2,6,9};
        // int[] B = {2,5,7,3,2,7};
        int[] A  = {5, 9, 10, 4, 7, 8 };
        int[] B = { 5, 6, 4, 7, 2, 5};
        int res = minCost(A, B);
        System.out.println(res);
    }
}
