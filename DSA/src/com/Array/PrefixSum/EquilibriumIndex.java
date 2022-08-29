package com.Array.PrefixSum;

import java.util.*;

public class EquilibriumIndex {

    //to get leftSum
    public static int getLeftSum(int L , int R, int[] A) {
        int sum = 0;
        for(int i = L; i<=R; i++) {
            sum += A[i];
        }
        return sum;
    }

    public static int getRightSum(int L , int R, int[] A) {
        int sum = 0;
        for(int i = L; i<=R; i++) {
            sum += A[i];
        }
        return sum;
    }

    public static int getCountEquilibriumCount(int[] A) {
        int n = A.length;
        ArrayList<Integer> equiIndexArr = new ArrayList<Integer>();
        int leftSum = 0;
        int rightSum = 0;
        //create PFsum[] of n size
        int PFsum[] = new int[n];
        PFsum[0] = A[0];
        for(int i=1;i<n;i++){
            PFsum[i] = PFsum[i-1] + A[i];
        }
        for(int i=0;i<n;i++){
            if(i != 0) {
                //leftSum = getLeftSum(0, i-1, A);
                leftSum = PFsum[i-1];
            } else {
                leftSum = 0;
            }

            if(i == n-1) {
                rightSum = 0;
            } else {
                //rightSum = getRightSum(i+1, n-1, A);
                rightSum = PFsum[n-1] - PFsum[i+1-1];
            }

            if(leftSum == rightSum){
                equiIndexArr.add(i);
            }
        }
         //if not index is equilibrium
         if(equiIndexArr.size() == 0) {
            return -1;
        }

        //if equilibrium index is there return minumum index
        int min = Integer.MAX_VALUE;
        for(int i=0;i<equiIndexArr.size(); i++){
            if(equiIndexArr.get(i) < min){
                min = equiIndexArr.get(i);
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[] A = {-3,2,4,-1};
        int res = getCountEquilibriumCount(A);
        System.out.println(res);
    }
}
