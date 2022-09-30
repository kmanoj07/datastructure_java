package com.Array.AdvancedArray;

public class Maxsubarraysum {

    //Kadane's algorithm
    public static int maxSubArrayOpt(int[] A) {
        int N = A.length;
        int sum = 0;
        int ans = A[0];
        for(int i=0; i<N; i++){
            sum = sum + A[i];
            if(sum > ans){
                ans = sum;
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
 
    //TC - O(N^2)
    //SC - O(N)
    public static int maxSubArrayUsingPf(int[] A) {
        int N = A.length;

        //create pf array
        int[] pf =  new int[N];
        pf[0] = A[0];
        for(int i=1;i<N;i++){
            pf[i] = pf[i-1] + A[i];
        }

        int maxSum = A[0]; //single ele is sub array 
        for(int i=0;i<N; i++){
            for(int j = i; j<N; j++){
                int curSum;
                if(i == 0){
                    curSum = pf[j];
                } else {
                    curSum = pf[j] - pf[i-1];
                }
                if(curSum > maxSum){
                    maxSum = curSum;
                }
            }
        }
        return maxSum;
    }


    //TC - O(N^3)
    //SC - O(1)
    public static int maxSubArray(int[] A) {
        int N = A.length;
        int maxSum = A[0]; //single ele is sub array 
        for(int i=0;i<N; i++){
            for(int j = i; j<N; j++){
                int curSum = 0;
                for(int s = i; s <= j; s++) {
                    curSum += A[s];
                }
                if(curSum > maxSum){
                    maxSum = curSum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args)
    {
        int[] A = {-500};
        int result = maxSubArrayOpt(A);
        System.out.println(result);
    }
}
