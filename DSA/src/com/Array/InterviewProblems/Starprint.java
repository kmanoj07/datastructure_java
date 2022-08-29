package com.Array.InterviewProblems;

import java.util.Scanner;

public class Starprint {

    public static void printStar() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int i = 0;
        while(i < n){
            int star = n - i;
            while (star > 0){
                System.out.print("*");
                star--;
            }System.out.println();
            i++;
        }
    }

    public static void printDiamond() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int i = 0;
        while (i < n) {
            //print start
            int star = n - i;
            while (star > 0) {
                System.out.print("*");
                star--;
            }
            //print space
            int space = 2*i;
            while (space > 0) {
                System.out.print("_");
                space--;
            }
            //print star
            star = n-i;
            while (star > 0) {
                System.out.print("*");
                star--;
            }
            System.out.println();
            i++;
        }

        int j = 0;
        while (j < n) {
            //print Star
            int star = j+1;
            while (star > 0) {
                System.out.print("*");
                star--;
            }
            //print space
            int space = (n-(j+1)) * 2;
            while (space > 0) {
                System.out.print("_");
                space--;
            }
            //print star
            star = j+1;
            while (star > 0) {
                System.out.print("*");
                star--;
            }
            System.out.println();
            j++;
        }
    }

    public static void main(String[] args) {
        //printStar();
        printDiamond();
    }
}
