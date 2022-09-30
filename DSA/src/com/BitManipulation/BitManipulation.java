package com.BitManipulation;

public class BitManipulation {

    public static String addBinary(String A, String B) {
        int str1LastIndex = A.length() - 1;
        int str2LastIndex = B.length() - 1;

        StringBuilder ansStr = new StringBuilder();
        int carry = 0;

        while (str1LastIndex >= 0 || str2LastIndex >= 0) {

            int sum = carry;

            if (str1LastIndex >= 0) {
                sum += A.charAt(str1LastIndex) - '0';
            }
            if (str2LastIndex >= 0) {
                sum += B.charAt(str2LastIndex) - '0';
            }

            // ans
            ansStr.append(sum % 2);
            carry = (sum) / 2;

            str1LastIndex--;
            str2LastIndex--;
        }

        if (carry != 0) {
            ansStr.append(carry);
        }

        return ansStr.reverse().toString();
    }

    public static long reverse32Bitint(long a) {
        long ans = 0;
        for (int i = 0; i <= 31; i++) {
            // determine the set bit
            long bit = (a >> i) & 1;
            ans = ans | bit << 31 - i;
        }
        return ans;

    }

    public static void main(String[] args) {
        // String A = "11";
        // String B = "1";

        // String sum = addBinary(A, B);
        // System.out.println(sum);
        long reverseInt = reverse32Bitint(3);
        System.out.println(reverseInt);
    }
}
