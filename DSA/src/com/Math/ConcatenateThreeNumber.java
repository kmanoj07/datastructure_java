package com.Math;

import java.util.Arrays;

public class ConcatenateThreeNumber {
    
    public static int concatenateThreeNum(int A, int B, int C) {
        int[] arr = new int[3]; // constant size 3
        arr[0] = A;
        arr[1] = B;
        arr[2] = C;

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<arr.length; i++) {
            sb.append(arr[i]);
        }
        
        return Integer.parseInt(sb.toString());
    }
    
    public static void main(String[] args) {
        int res = concatenateThreeNum(55, 43, 47);
        System.out.println(res);
    }
}
