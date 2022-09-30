package com.Array.AdvancedArray;

public class MaxPosInteger {
    public static int firstMissingPositive(int[] A) {
        int i = 0;
        int N = A.length;
        while (i < N) {
            if(A[i] < 1 || A[i] > N || A[i] == (i+1)) {
                i++;
            } else {
                int correctIndexPos = (A[i] - 1); //getting the correct position for the current ele
                //we will swap the current ele with its correctIndexPos
                if(A[i] == A[correctIndexPos]){
                    i++;
                }  else {
                int val = A[i];
                A[correctIndexPos] = A[i];
                A[i] = val;
                }
            }
        }

        for(int j=0;j<N;i++){
            if(A[j] != (j + 1)){
                return j+1;
            }
        }
        
        return N + 1;
    }
    
    
    public static void main(String[] args) {
        int[] arr = {1,2,0};
        System.out.println(firstMissingPositive(arr));
    }
}
