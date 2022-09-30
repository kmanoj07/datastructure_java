package com.String;

public class PallindromicSubString {    

    public static int getlen(int start, int end, String str) {
        int N = str.length();
        while (start >=0 && end < N && (str.charAt(start) == str.charAt(end)) )
        {
            start--;
            end++;
        }
        return ((end - start + 1) -2);
    }
    public static int largestPallindromicSubStrLen(String str) {
        int maxLen = 1;
        int N = str.length();
        for(int i=0; i<N; i++){
            int oddLen = getlen(i, i, str);
            //System.out.println(oddLen);
            int evenLen =  getlen(i, i+1, str);
            //System.out.println(evenLen);
            maxLen = Math.max(Math.max(oddLen, evenLen), maxLen);
        }
        return maxLen;
    }
    public static void main(String[] args){
        String str = "malayalam";
        int len = largestPallindromicSubStrLen(str);
        System.out.println(len);
    }
}
