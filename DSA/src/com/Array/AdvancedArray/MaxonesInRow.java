package com.Array.AdvancedArray;

public class MaxonesInRow {
    
    public static int maxNumonesinrow(int[][] A) {
        int N = A.length;
        int M = A[0].length;

        //keep trak of row
        int r = -1;
        int a = M;

        int i = 0;
        int j = N-1;

        while(i < N && j >=0) {
            if(A[i][j] == 1) {
                r = i;
                a = j;
                j--;
            } else {
                i++;
            }
        }

        return r; //return the row number which is having the maxnumberof ones

    }

    //T.C O(N*M)
    public static int solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;

        int r = -1;
        int maxones = 0;

        for(int i=0;i<N;i++){
            int onescount = 0;
            for(int j=N-1; j>=0;j--){
                if(A[i][j] == 1){
                    onescount += 1;
                }
            }
            if(onescount > maxones){
                maxones = onescount;
                r = i;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[][] A = {
            {0,1,1},
            {0,0,1},
            {0,1,1}
        };

        int rowWithmaxOne = maxNumonesinrow(A);
        System.out.println(rowWithmaxOne);
    }
}
