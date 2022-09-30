package com.Array.AdvancedArray;

public class AdvancedArray {

    public static void printArray(int[] A) {
        int N = A.length;
        for(int i=0;i<N;i++){
            System.out.print(A[i] + " ");
        } System.out.println();
    }
    
    public static int trap(final int[] A) {
        int N = A.length;
        int ans = 0;

        //creating the PFmax
        int[] PFMax = new int[N];
        int cpMax = A[0];
        PFMax[0] = cpMax;
        for(int i=1;i<N;i++){
            if(A[i] > cpMax){
                cpMax = A[i]; 
                PFMax[i] = cpMax;
            } else {
                PFMax[i] = PFMax[i-1];
            }
        }

        //printArray(PFMax);

        //Creating the SFmax
        int[] SFMax = new int[N];
        int spMax = A[N-1];
        SFMax[N-1] = spMax;
        for(int i=N-2;i>=0;i--){
            if(A[i] > spMax){
                spMax = A[i];
                SFMax[i] = spMax;
            } else {
                SFMax[i] = SFMax[i+1];
            }
        }

        //printArray(SFMax);

        //ignoring the corner towers
        for(int i=1; i<N-1; i++){
            int lMax = PFMax[i-1];
            int rMax = SFMax[i+1];
            int level = Math.min(lMax, rMax);
            int amount  = level - A[i];
            if(amount > 0) {
                ans = ans + (level - A[i]);
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        int[] A = {1,2};
        int ans = trap(A);
        
        System.out.println("Total water trapped is " + ans) ;
        System.out.println(-25%5);
        System.out.println(-25%1);
    }
}
