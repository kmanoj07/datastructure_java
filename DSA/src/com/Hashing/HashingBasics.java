package com.Hashing;
import java.util.HashSet;

public class HashingBasics {
    

    //TC = O(N^2) sc O(1)
    //Optimize - TC O(N) SC  O(N)
    public static boolean pairSumExist(int[] A, int K) {
        int N = A.length;

        //Create hashSet
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i<N; ++i) {
            hs.add(A[i]);
        }
        
        for (int i=0; i<N;i++) {
            int a = A[i], b = (K - a);

            //So this searching part is taking the time O(N)
            // for (int j=i+1; j<N;j++) {
            //     if (A[j] == b) {
            //         return true;
            //     }
            // }
            //checking if the b value is present in the Hashset
            if (hs.contains(b)) {
                return true;
            } 
        }

        return false;
    }
    
    public static void main(String[] args) {

    }
}
