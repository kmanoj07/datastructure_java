package com.Math;

import java.util.Scanner;
public class Lcm {
    public static int LCM(int a, int b) {
        int lcm = 0;
        //lcm can not be smaller than the largest value of a and b
        lcm = (a > b) ? a : b;
        while (true) {
            if(lcm % a == 0 && lcm % b == 0 ){
                return lcm;
            }
            lcm ++;
        }
    }
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        while (T > 0) {
            int a = scn.nextInt();
            int b = scn.nextInt();
            System.out.println(LCM(a, b));
            T--;
        }
    }
}
