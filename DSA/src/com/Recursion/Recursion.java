package com.Recursion;

import java.util.Scanner;

public class Recursion {

    public static void printRev(String str, int N) {
        if(N == 0){
            return;
        }
        System.out.print(str.charAt(N-1));
        printRev(str, N-1);
    }

    public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      String str = scn.nextLine();
      int N = str.length();
      printRev(str, N);
    }
}
