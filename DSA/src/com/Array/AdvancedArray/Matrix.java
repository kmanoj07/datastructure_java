package com.Array.AdvancedArray;

import java.util.ArrayList;

public class Matrix {

    public static long getMaxSubMatrixSum(int[][] A) {
        int N = A.length;
        int M = A[0].length;

        //creating pfm
        int[][] pfm = new int[N][M];

        //copying the array value to pfm
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++) {
                pfm[i][j] = A[i][j];
            }
        }

        //Creating pfm using row wise sum;
        for(int i=0; i<N;i++){
            for(int j=1; j<M; j++){
                pfm[i][j] = pfm[i][j-1] + pfm[i][j];
            }
        }

        //creating pfm using col wise
        for(int j=0;j<M;j++){
            for(int i=1;i<N;i++){
                pfm[i][j] = pfm[i-1][j] + pfm[i][j];
            }
        }

        long ans = pfm[0][0];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++){
                
                //top left corner co-ordinated
                int x1 = i;
                int y1 = j;

                //bottom right corner co-ordinates
                int x2 = N-1;
                int y2 = M-1;

                long sum = pfm[x2][y2];
                if(y1 > 0){
                    sum = sum - (pfm[x2][y1-1]);
                }
                if(x1 > 0){
                    sum = sum - (pfm[x1-1][y2]);
                }
                if(x1 > 0 && y1 > 0){
                    sum = sum + pfm[x1-1][y1-1];
                }

                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

    public static ArrayList<Integer> getPsmat(int[][] arr, int[] B, int[] C, int[] D, int[] E) {
        int N = arr.length;
        int M = arr[0].length;
        int[][] psmat = new int[N][M];
        ArrayList<Integer> list = new ArrayList<Integer>();

        // copying the arr
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                psmat[i][j] = arr[i][j];
            }
        }

        // rows wise psum
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < M; j++) {
                psmat[i][j] = psmat[i][j - 1] + psmat[i][j];
            }
        }

        // colwise psum
        for (int j = 0; j < N; j++) {
            for (int i = 1; i < M; i++) {
                psmat[i][j] = psmat[i - 1][j] + psmat[i][j];
            }
        }

        for (int i = 0; i <= 1; i++) {
            int x1 = B[i];
            int y1 = C[i];

            x1 = x1-1;
            y1 = y1-1;

            int x2 = D[i];
            int y2 = E[i];

            x2 = x2 -1;
            y2 = y2-1;

            int sum = psmat[x2][y2];
            if(y1 > 0){
                sum = sum - (psmat[x2][y1-1]);
            }
            if(x1 > 0){
                sum = sum - (psmat[x1-1][y2]);
            }
            if(x1>0 && y1>0){
                sum = sum + psmat[x1-1][y1-1];
            }

            list.add(sum);
        }

        return list;

    }

    public static void print(int[][] psmat) {
        for (int i = 0; i < psmat.length; i++) {
            for (int j = 0; j < psmat[0].length; j++) {
                System.out.print(psmat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // int[] B = { 1, 2 };
        // int[] C = { 1, 2 };
        // int[] D = { 2, 3 };
        // int[] E = { 2, 3 };
        // ArrayList<Integer> arrpsmat = getPsmat(arr, B, C, D, E);
        // for(int n: arrpsmat){
        //     System.out.println(n);
        // }

        int[][] A = {
            {-83, -73, -70, -61},
            {-56, -48, -13, 4},
            {38, 48, 71, 71}
        };

        int[][] B = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        long result =  getMaxSubMatrixSum(A);
        System.out.println(result);
       
    }
}
