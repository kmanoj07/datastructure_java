package com.AdvancedGcd;

public class Main {

    // To: Everyone//9573546915

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int deleteOne(int[] A) {
        int N = A.length;
        int ans = 0;

        // create pfgcd
        int[] pfgcd = new int[N];
        for (int i = 0; i < N; i++) {
            ans = gcd(ans, A[i]);
            pfgcd[i] = ans;
        }
        // create Sfgcd
        int[] sfgcd = new int[N];
        ans = 0;
        for (int i = N - 1; i >= 0; i--) {
            ans = gcd(ans, A[i]);
            sfgcd[i] = ans;
        }
        // handling the edge cases
        ans = Math.max(sfgcd[1], pfgcd[N - 2]);

        for (int i = 1; i < N - 1; i++) {
            int leftgcd = pfgcd[i - 1];
            int rightgcd = sfgcd[i + 1];
            int overallgcd = gcd(leftgcd, rightgcd);

            ans = Math.max(ans, overallgcd);
        }
        return ans;
    }

    public static void main(String[] args) {

        // delete one element
        int[] A = { 3, 9, 6, 8, 3 };
        int maxGcd = deleteOne(A);
        System.out.println(maxGcd);

    }
}
