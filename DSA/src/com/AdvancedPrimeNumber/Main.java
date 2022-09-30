package com.AdvancedPrimeNumber;
import java.util.ArrayList;

public class Main {

    public static int[] cntFactorOpt(int A[]) {
        //get the max of an array
        int max = getMax(A);
        //create divArray
        int[] diviArray = new int[max + 1];

        diviArray[1] = 1;
        for (int i=2; i < diviArray.length; i++) {
            diviArray[i] = 2;
        }

        for (int j = 2; j < diviArray.length; j++) {
            for(int l = j+j;l<diviArray.length;l+=j){
                diviArray[l] += 1;
            } 
        }

        for (int k = 0; k<A.length; k++) {
            A[k] = diviArray[A[k]];
        }

        return A;
    }

    public static int getMax(int A[]) {
        int max = Integer.MIN_VALUE;
        for (int i=0;i<A.length; i++) {
            if(A[i]> max) {
                max = A[i];
            }
        }
        return max;
    }

    public static ArrayList<Integer> countFactor(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int N = A.size();

        //loop over every element of the array
        for (int i=0;i<N; i++) {
            //couting the divisor for each ith ele
            int ele = A.get(i);
            int count = 0;
            for (int j=1; j <= ele; j++) {
                if(ele % j == 0){
                    count ++;
                }
            }
            //add that count to the rest list
            res.add(count);
        }

        return res;
    }

    public static void printArray(ArrayList<Integer> A) {
        int N = A.size();
        for (int i=0; i < N; i++) {
            System.out.println(A.get(i));
        }
    }

    public static void printArray(int[] A) {
        for (int i=0;i<A.length; i++) {
            System.out.println(A[i]);
        }
    }
    
    public static void main(String[] args) {
        // ArrayList<Integer> A = new ArrayList<Integer>();
        // A.add(2);
        // A.add(3);
        // A.add(4);
        // A.add(5);
        // ArrayList<Integer> restA = countFactor(A);
        //printArray(restA);

        int[] arr = {2,3,4,5};
        int[] resArr = cntFactorOpt(arr);
        printArray(resArr);
    }
}
