package com.Array.CarryForward;

public class AmazingSubArray {
    public static int printSubStringOpt(String A){
        int n = A.length();
        int subStrcnt = 0;
        for(int i=0;i<n;i++){
            char ch = A.charAt(i);
            if(ch == 'a' || ch =='e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch =='U') {
                int count = n - i;
                subStrcnt += count;
            }
            subStrcnt = subStrcnt % 10003;
        }
        return subStrcnt;
    }
    public static int printSubString(String A){
        int n = A.length();
        int subStrcnt = 0;
        for(int i=0;i<n;i++){
            char ch = A.charAt(i);
            if(ch == 'a' || ch =='e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch =='U') {
                for(int j= i; j<n; j++){
                    subStrcnt++;
                    // for(int k = i;k<=j; k++){
                    //     System.out.print(A.charAt(k));
                    // }System.out.println();
                }
            }
            subStrcnt = subStrcnt % 10003;
        }
        return subStrcnt;
    }
    public static void main(String[] args){
        String A = "AAAA";
        int res =  printSubStringOpt(A);
        System.out.println(res);
    }
}
