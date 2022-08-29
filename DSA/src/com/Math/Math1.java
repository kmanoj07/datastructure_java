package com.Math;

public class Math1 {

    public static int titleToNumber(String A) {
        int number = 0;
        int n = A.length();
        for(int i=0;i<n;i++){
            int res = A.charAt(i) - 64;
            System.out.println(res);
            number = number * 26 + res;
            System.out.println(number);
        }
        return number;
    }

    public static void main(String[] args) 
    {
        String  title = "AB";
        System.out.println(titleToNumber(title));
    }
}
