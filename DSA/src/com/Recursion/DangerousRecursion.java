package com.Recursion;

public class DangerousRecursion {
    public static int runme(int num){
        if(num <= 0){
            return 0;
        } 
        else if(num == 1){
            return 1;
        }
        return runme(num-1) + runme(num-2);
    }

    public static void main(String[] args)
    {
        System.out.println(runme(10));
    }
}
