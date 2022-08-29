package com.String;

public class LongestPallindromicSubStr {
    public static String getLongestSubStrLen(String A) {
        int maxLen = 1;
        String str = Character.toString(A.charAt(0));
        int n = A.length();
        for (int i = 0; i<n; i++) {
            for (int j=i;j<n;j++) {
                //start i end j
                int len = (j-i)+1; 
                if(checkPalindrome(A, i, j)) {
                    if(len > maxLen){
                        str = "";
                        maxLen = len;
                        for (int k = i; k<=j; k++) {
                            str += A.charAt(k);
                        }
                    }
                }
            }
        }
        return str;
    }
    public static boolean checkPalindrome(String str, int sidx, int eidx) {
        boolean ans = true;
        while (sidx < eidx) {
            if (str.charAt(sidx) != str.charAt(eidx)) {
                return false;
            }
            sidx++;
            eidx--; 
        }
        return ans;
    }

    public static String getPallindromeLen(String str, int i, int j) {
        int N = str.length();
        StringBuilder sb = new StringBuilder();
        while (i>=0 && j < N && str.charAt(i) == str.charAt(j)) 
        {
            i--;
            j++;
        }

            for (int k=i+1; k<=j-1; k++)
            {
                sb.append(str.charAt(k));
            }
        return sb.toString();
    }
    public static String solve(String str) {
        int n = str.length();
        int maxLen = 1;
        String s = Character.toString(str.charAt(0));
        for (int i=0;i<n; i++) {
            String oddLen = getPallindromeLen(str, i, i);
            String evenLen = getPallindromeLen(str, i, i+1);

            if((oddLen.length() > evenLen.length()) && (oddLen.length() > maxLen)) {
                maxLen = oddLen.length();
                s = oddLen;
            } else if((evenLen.length() > oddLen.length()) && (evenLen.length() > maxLen)) {
                maxLen = evenLen.length();
                s = evenLen;
            }
        }
        System.out.println(maxLen);
        return s;
    }
    public static void main(String[] args) {
        String res = solve("aaaabaaa");
        System.out.println(res);
    }
    
}
