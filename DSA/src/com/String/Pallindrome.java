package com.String;

public class Pallindrome {
    
    public static boolean checkPallindrom(String str, int start, int end) {
        while (start < end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++; end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "anamadamaspe";
        boolean rest = checkPallindrom(str, 3, 7);
        if(rest) {
            System.out.println("Pallindrome");
        } else {
            System.out.println("No Pallindrome");
        }
    }
}
