package com.contest;

public class Contest {

    public static String flipBit(String str) {
        int N = str.length();
        StringBuilder resStr = new StringBuilder();
        for (int i = N - 1; i >= 0; i--) {
            int bit = (str.charAt(i) - '0') ^ 1;
            resStr.append(bit);
        }

        return resStr.reverse().toString();
    }

    // public static String addBinaryUtil(String str1, String str2) {
    //     int str1len = str1.length()-1;
    //     int str2len = str2.length()-1;
    //     int carry = 0;
    //     StringBuilder resStr = new StringBuilder();
    //     while (str1len >= 0 || str2len >= 0) {
    //         int sum = carry;
    //         if(!str1.isEmpty()) {
    //             if (str1len >= 0) {
    //                 sum += str1.charAt(str1len) - '0';
    //             }
    //         } else {
    //             sum += 0;
    //         }
    //         if (str2len >= 0) {
    //             sum += str2.charAt(str2len) - '0';
    //         }
    //         resStr.append(sum % 2);
    //         carry = sum / 2;

    //         str1len--;
    //         str2len--;
    //     }

    //     return resStr.reverse().toString();

    // }

    static String addBinaryUtil(String a, String b)
    {
        String result = ""; // Initialize result
        int s = 0; // Initialize digit sum
 
        // Traverse both strings starting
        // from last characters
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1)
        {
 
            // Compute sum of last digits and carry
            s += ((i >= 0) ? a.charAt(i) - '0' : 0);
            s += ((j >= 0) ? b.charAt(j) - '0' : 0);
 
            // If current digit sum is 1 or 3,
            // add 1 to result
            result = s % 2 + result;
 
            // Compute carry
            s /= 2;
 
            // Move to next digits
            i--;
            j--;
        }
        return result;
    }

    public static String addBinary(String[] strArr, int len) {
        String result = "";
        for (int i = 0; i < len; i++) {
            result = addBinaryUtil(result, strArr[i]);
        }
        return result;
    }

    public static int getSum (String s) {
        int N = s.length()-1;
        int sum = 0;
        int pos = 1;
        for(int i=N; i >= 0; i--){
            int lastDigit = (s.charAt(i) - '0');
            sum = sum + (lastDigit * pos);
            pos = pos * 2;
        }
        return sum;
    }

    public static  String greaterBinary(String s1, String s2) {
        String res = "";
        if(getSum(s1) > getSum(s2)) {
            res = s1;
        } else {
            res = s2;
        }
        return res;
    }


    public static void main(String[] args) {
        String[] A = { "1","1", "0", "0", "1", "1", "1", "1"};
        int N = A.length;
        String initSum = addBinary(A, N);

        for(int i = 0; i<N; i++) {
            String str = "";
            if(A[i].charAt(0)-'0' == 0){
               str = flipBit(A[i]);
               A[i] = str;
               break;
            }
        }

        String getSum = addBinary(A, N);
        System.out.println(initSum);
        System.out.println(getSum);
        String res = greaterBinary(initSum,getSum);
        System.out.println(res);
    }
}
