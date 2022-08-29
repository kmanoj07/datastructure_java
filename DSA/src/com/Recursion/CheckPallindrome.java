package com.Recursion;

public class CheckPallindrome {
    
    boolean checkPalindrome(String A, int start, int end) {
        //base condition
        if(start > end){
            return true;
        }
        //p = Subproblem + work
        if((A.charAt(start)) == (A.charAt(end)) && checkPalindrome(A, start + 1, end - 1)) {
            return true;
        }

        return false;
    }

    public int solve(String A) {
        int s = 0;
        int e = A.length()-1;
        if(checkPalindrome(A, s , e)) {
            return 1;
        } else {
            return 0;
        }
    }
}
