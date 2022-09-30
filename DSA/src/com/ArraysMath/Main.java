package com.ArraysMath;

public class Main {


    public static int getNearPower2(int N) {
        int ans = 1;
        if (N == 1) {
            return ans;
        }
        for (int i = 0; i <  32 ; i ++) {
            //getting the power of 2 using bit manipulation wiht left shit by i
            int val = 1 << i;
            if (val <= N) {
                ans = val;
            } else {
                break;
            }
        }
   
        return ans;
    }

    //josphes killing problem
    public static int lastmanStanding(int N) {
        //calculate the power of 2 <= N
        int npow2 = getNearPower2(N);
        
        int nKill = N - npow2;

        //The killing starts from 1 and for each killing take 2 jump
        int ans = 1 + (nKill * 2);
        return ans;
    }


    //Moores voting algorithm
    public static int majorityEle(int[] A) {
        int N = A.length;
        int ele = A[0];
        int fre = 1;
        if(N == 1) {
            return ele;
        }

        for (int i=1; i<N; i++) {
            if(fre == 0) {
                ele = A[i];
                fre = 1;
            }

            if(ele == A[i]) {
                fre  += 1;
            } else {
                fre -= 1;
            }
        }

        int count = 0;
        for (int i=0; i<N; i++) {
            if (ele == A[i]) {
                count += 1;
            }
        }

        if(count > N/2) {
            return ele;
        }

        return -1;
    }
    
    public static void main(String[] args) {

       // int[] A = {4, 6, 5, 3, 4, 5, 6, 4, 4, 4};
        int[] A = {3,4,3,3,6,3,7};
        int res = majorityEle(A);
        System.out.println(res);

        int N = 11;
        System.out.println(lastmanStanding(N));

    }
}
