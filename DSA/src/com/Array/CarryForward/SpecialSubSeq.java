package com.Array.CarryForward;

public class SpecialSubSeq {

    public static int specialSubSeqCount(String A) {
        int n = A.length();
        //int cnt = 0;
        // //brute force approach
        // for(int i=0;i<n-1;i++) {
        //     if(A.charAt(i) == 'A') {
        //         for(int j=i+1;j<n;j++){
        //             if(A.charAt(j) == 'G'){
        //                 cnt++;
        //             }
        //         }
        //     }
        // }
        int ans = 0;
        int cntG = 0;
        for(int i=n-1; i>=0; i--){
            if(A.charAt(i) == 'G'){
                cntG += 1;
            }
            else if(A.charAt(i) == 'A') {
                ans = ans + cntG;
            }
        }
        return ans;
    }

    public static void main(String[] args) 
    {
        String A = "GAB";
        int res = specialSubSeqCount(A);
        System.out.println(res);
    }
    
}
