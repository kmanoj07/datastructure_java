package com.IntermediateContest1;

import java.util.ArrayList;
public class Contest {

    public static ArrayList<Integer> vowelCnt(String str, int[][] B) {
        int n = str.length();
        int r = B.length;
        int c = B[0].length;
        ArrayList<Integer> ans  = new ArrayList<Integer>();

        //prefix arr
        int[] Pvcnt = new int[n];
        //vowel cnt
        if(str.charAt(0) == 'a' || 
                    str.charAt(0) == 'e'|| 
                    str.charAt(0) == 'i'||
                    str.charAt(0) == 'o'||
                    str.charAt(0) == 'u' )
        {
            Pvcnt[0] = 1;
        } else {
            Pvcnt[0] = 0;
        }

        for (int i=1;i<n;i++){
            //vowel cnt
                if(str.charAt(i) == 'a' || 
                    str.charAt(i) == 'e'|| 
                    str.charAt(i) == 'i'||
                    str.charAt(i) == 'o'||
                    str.charAt(i) == 'u' )
                {
                    Pvcnt[i] = Pvcnt[i-1] + 1;
                } else {
                    Pvcnt[i] = Pvcnt[i-1];
                }
        }
        //loop over queris
        for (int i=0;i<r;i++) {
                int L = B[i][0];
                int R = B[i][1];
                int t = 0;
                
                if(i == 0) {
                    t = Pvcnt[R];
                } else {
                    t = Pvcnt[R] - Pvcnt[L-1];
                }

                ans.add(t);
        }
        return ans;

    }
    public static void print(ArrayList<Integer> A) {
        int n = A.size();
        for (int i=0;i<n;i++) {
            System.out.print(A.get(i) + " ");
        }System.out.println();
    }

    public static int createBinary(int A, int B) {
        //A 1s'
        //B 0's
        String bStr = "";
        int res = 0;
        
        for (int i=1;i <=A;i++) {
            bStr += "1";
        }
        for (int j=1;j<=B;j++){
            bStr += "0";
        }

        int len = bStr.length();
        int pos = 0;
        int base = 2;

        while (len > 0) {
            char ch = bStr.charAt(len-1);
            int digit = ch - '0';
            res += digit * Math.pow(base, pos);
            pos++;
            len--;
        }

        return res;

    }

    // public static int getMax(int[] A) {
    //     int n = A.length;
    //     int max = Integer.MIN_VALUE;
    //     for (int i= 0;i<n;i++){
    //         if (A[i] > max) {
    //             max = A[i];
    //         }
    //     }
    //     return max;
    // }

    // public static void updateMaxvalIndexminus1(int[] A, int max) {
    //     for (int i=0;i<A.length;i++) {
    //         if (A[i] == max) {
    //             A[i] = -1;
    //         }
    //     }
    // }

    public static boolean isExist(int[] A, int B) {
        int n = A.length;
        for (int i=0;i<n;i++) {
            if(A[i] == B) {
                return true;
            }
        }
        return false;
    }
    public static int littlePonnyMinOp(int[] A, int B) {
       int cnt = 0;
       int n = A.length;
        boolean exist = isExist(A, B);
        if (exist){
            for (int j=0;j<n;j++) {
                if(A[j] > B) {
                    cnt++;
                    A[j] = -1;
                }
            }
        }
       return cnt;
    }

    public static void main(String[] args) {
        //vowel count
        // String str = "scaler";
        // int[][] B = new int[][] {{0,1}, {1,3}};
        // ArrayList<Integer> vCnt = vowelCnt(str, B);
        // print(vCnt);
        // //create binary 
        // int A = 3;
        // int c = 2; 
        // int dRes = createBinary(A, c);
        // System.out.println(dRes);

        //little ponny and max count
        int[] D = {2, 4, 3, 1, 5};
        int E = 3;
        int minOp = littlePonnyMinOp(D, E);
        System.out.println(minOp);
    }
}
