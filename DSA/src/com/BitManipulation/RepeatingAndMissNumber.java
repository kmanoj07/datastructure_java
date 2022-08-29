package com.BitManipulation;

import java.util.Arrays;

public class RepeatingAndMissNumber {
    public static int[] repeatingMissNumber(int[] arr) {
        int missNum = 0;
        
        int N = arr.length;
        for (int i=1; i<=N; i++) {
            missNum = (missNum ^ (i ^ arr[i-1]));
        }
        System.out.println(missNum);

        int idx = 0;
        for(int i =0;i<32;i++) {
            if(((1 << i) & missNum) != 0) {// set bit index of num
                idx = i;
                break;
            }
        }

        System.out.println(idx);

        int n1 = 0;
        int n2 = 0;

        for (int i = 1; i<=N; i++) {
            if((i &((i-1)<<idx)) == 0 && (arr[i-1]&(i-1<<idx)) == 0) {
                n1 = n1 ^ i ^ arr[i-1];
            }
            else {
                n2 = n2 ^ i ^ arr[i-1];
            }
        }
        return new int[] {n1, n2};
    }
    public static int[] repeatingNumber(int[] A) {
        int xor = 0;
        int n = A.length;

        //not ideal arr
        for(int i=0;i<n;i++) {
            xor = xor ^ A[i];
        }
        //ideal arr case
        for(int i = 1; i<=n; i++){
            xor = xor ^ i;
        }
        //finding rsb of XOR num
        int rsb = xor & -xor;
        // System.out.println(rsb);
        // int rsbidx = 0;
        // for(int i=0;i<32;i++)
        // {
        //     if((xor & (1 <<i )) != 0)
        //     {
        //         rsbidx = i;
        //         break;
        //     }
        // }
        //System.out.println("The tight most set bit index of XOR number " + rsbidx);
        //create two seperate set to hold 
        // set bit on and set bit off
        int n1= 0;
        int n2 = 0;

        //not ideal case arr element val right most set bit
        for (int val : A) {
            if((val & rsb ) == 0) { //rsb off
                n1 = n1 ^ val;
            } else {
                n2 = n2 ^ val;
            }
        }

        //ideal case array elem right moset seetbit
        for (int i = 1; i<=n; i++) {
            if((i & rsb ) == 0) { //rsb off
                n1 = n1 ^ i;
            } else {
                n2 = n2 ^ i;
            }
        }

        //we have two numbers now 
        // determine which is diplicate and repeating
        //int[] rs = new int[2];
        int repeatingNum = 0;
        int missingNum = 0;
        for (int val: A) {
            if(val == n1){
                System.out.println("Repeating Number -> " + n1);
                repeatingNum = n1;
                System.out.println("Missing Number -> " + n2);
                missingNum = n2;
                break;

            }
            
           else if(val == n2){
                System.out.println("Repeating Number -> " + n2);
                repeatingNum = n2;
                System.out.println("Missing Number -> " + n1);
                missingNum = n1;
               break;
            }
        }

        return new int[] {repeatingNum, missingNum};


    }
    public static void main(String[] args)
    {
        int[] arr = {3,1, 2, 5, 3};
        int[] res = repeatingNumber(arr);
        System.out.println(Arrays.toString(res));
    }
}
