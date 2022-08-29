package com.Array.ArrayIntro;

public class SecondLarget {
    public static int getmax(int[] A) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            if(A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

    public static int getMaxCount(int max, int[] A) {
        int cnt = 0;
        for(int i=0;i<A.length;i++){
            if(A[i] == max){
                cnt++;
            }
        }
        return cnt;
    }
    
    public static int solve(int[] A) {
        int n = A.length;
        int max = getmax(A);
        System.out.println(max);
        int cntMax = getMaxCount(max, A);
        System.out.println(cntMax);
        int nSize = n - cntMax;
        if(n == 1){
            return -1;
        }
        if(cntMax == n) {
            return max;
        }
        if(nSize == 0 && cntMax != n) {
            return -1;
        }
        int[] nA = new int[nSize];
        int sindex = 0;
        for(int i=0;i<n;i++){
            if(A[i] != max) {
                nA[sindex] = A[i];
                sindex++;
            }
        }
        return getmax(nA);
    }
    public static void main(String[] args) {
        int[] A  = {2,2};
        int res= solve(A);
        System.out.println("Second Largest " + res);
    }
}
