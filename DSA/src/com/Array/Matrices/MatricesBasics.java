package com.Array.Matrices;

public class MatricesBasics {

    public static int cntLeft_1s(int idx, int[] A) {
        int cnt = 0;
        for (int i = idx; i >= 0; i--) {
            if (A[i] != 0) {
                cnt = cnt + 1;
            } else {
                break;
            }
        }
        return cnt;
    }

    public static int cntRight_1s(int idx, int[] A) {
        int cnt = 0;
        int n = A.length;
        for (int i = idx; i < n; i++) {
            if (A[i] != 0) {
                cnt = cnt + 1;
            } else {
                break;
            }
        }
        return cnt;
    }

    public static int consective_ones(int[] A) {
        int n = A.length;
        int maxOnes = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                int left = 0;
                if (i > 0) {
                    left = cntLeft_1s(i - 1, A);
                }
                int right = 0;
                if (i < n) {
                    right = cntRight_1s(i + 1, A);
                }

                int total = left + right + 1;

                if (total > maxOnes) {
                    maxOnes = total;
                }
            }
        }
        return maxOnes == 0 ? n : maxOnes;
    }

    public static int max_sub_arr_sum_pfs(int[] A, int k) {
        int n = A.length;

        // create pfs array
        int pf[] = new int[n];
        pf[0] = A[0];
        for (int i = 1; i < n; i++) {
            pf[i] = pf[i - 1] + A[i];
        }

        int s = 0;
        int e = k - 1;

        int max = Integer.MIN_VALUE;

        while (e < n) { // (n-k+1) time
            // range sum constant time
            int sum = (s == 0) ? pf[e] : (pf[e] - pf[s - 1]);
            if (sum > max) {
                max = sum;
            }
            e++;
            s++;
        }
        return max;
    }

    // iteratin over the every sub array of size k and get the sum for (n-k+1) times
    public static int max_sub_arr_sum(int[] A, int k) {
        int n = A.length;
        int s = 0;
        int e = k - 1;
        int max = Integer.MIN_VALUE;

        while (e < n) {
            // iterate over the s - e and get the sub array sum
            int sum = 0;
            for (int i = s; i <= e; i++) {
                sum = sum + A[i];
            }
            if (sum > max) {
                max = sum;
            }
            s++;
            e++;
        }
        return max;
    }

    // get max sub array sum of k size
    // Siliding window technique
    public static int max_sub_arr_sum_k_size(int A[], int k) {
        int n = A.length;
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        // calc first k size sum
        for (int i = 0; i < k; i++) {
            sum = sum + A[i];
        }
        // update the current ans as max subarray sum
        ans = sum;
        // computing the sum of next k size windows
        int s = 1;
        int e = k;

        while (e < n) {
            sum = (sum - A[s - 1]) + A[e];
            if (sum > ans) {
                ans = sum;
            }
            s++;
            e++;
        }

        return ans;
    }

    public static void main(String[] args) {
        // int[] A = { -3, 4, -2, 5, 3, -2, 8, 2, 1, 4 };

        // get sub array sum of size k
        // int res = max_sub_arr_sum(A, 6);
        // System.out.println(res);

        // max consective ones
        int B[] = { 0, 0, 0 };
        int res = consective_ones(B);
        System.out.println(res);
    }
}
