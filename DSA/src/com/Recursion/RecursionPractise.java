package com.Recursion;

import java.util.Stack;

public class RecursionPractise {

    // brute force approach
    // TC O(N^2)
    // SC O(1)
    public static int[] nearSmallestLeft(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            // now check the first Smallest ele left to A[i]
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i]) {
                    ans[i] = A[j];
                    break;
                }
            }
        }

        return ans;
    }

    public static int[] nearSmallestIndexRight(int[] A) {
        int n = A.length;
        Stack<Integer> st = new Stack<Integer>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }
        for (int i = n - 1; i >= 0; i--) {
            while (st.peek() >= 0 && st.size() > 0) {
                st.pop();
            }
            if (st.size() > 0) {
                ans[i] = st.peek();
            }
            st.push(i);
        }

        return ans;
    }

    public static int[] nearSmallestIndexLeft(int[] A) {
        int n = A.length;
        java.util.Stack<Integer> st = new java.util.Stack<Integer>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            while (st.peek() >= A[i] && st.size() > 0) {
                // remove an ele from stack
                st.pop();
            }

            if (st.size() > 0) {
                ans[i] = st.peek();
            }

            // push the current index i to stack
            st.push(i);
        }

        return ans;
    }

    public static int[] nearSmallestEleRight(int[] A) {
        int n = A.length;
        Stack<Integer> st = new Stack<Integer>();

        // create ans[]
        int[] ans = new int[n];
        // init -1;
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }

        // iterate from right
        for (int i = n - 1; i >= 0; i--) {

            while (st.peek() >= A[i] && st.size() > 0) {
                st.pop();
            }

            if (st.size() > 0) {
                ans[i] = st.peek();
            }

            st.push(A[i]);
        }

        return ans;
    }

    // Time complexity is
    // every A[i] ele is going 1 time in stack and coming 1 time from stack
    // TC n + n => O(N)
    // SC O(N) -- in the worst case all ele are sorted in increase order
    public static int[] nearSmallestEleLeft(int[] A) {
        int n = A.length;
        Stack<Integer> st = new Stack<Integer>();

        // create ans[] array
        int[] ans = new int[n];

        // initialize the ans array with the -1 if no first Nearest
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }

        // iterate over the array
        for (int i = 0; i < n; i++) {
            // compare the stack.top >= A[i]
            while (st.peek() >= A[i] && st.size() > 0) {
                st.pop();
            }
            // all ele >= A[i] has been pop()
            // now check the top() or peek , st.size > 0
            if (st.size() > 0) {
                ans[i] = st.peek();
            }
            // push the current A[i] ele to stack
            st.push(A[i]);
        }

        return ans;

    }

    public static int findKthindexEle(int n, int k) {

        if (k == 0) {
            return 0;
        }

        if (k % 2 == 0) {
            return findKthindexEle(n - 1, k / 2);
        } else {
            return 1 - findKthindexEle(n - 1, k / 2);
        }
    }

    // check pallindrom using the recursion
    // Assum : Given string str, check if the substr is pallindrome or not
    public static boolean checkPallindromeSubstr(String str, int start, int end) {
        // base condition
        // it means we have checked all the start and end character it means the string
        // is pallindrome
        if (start > end) {
            return true;
        }
        // Main logic
        // sub problem start char == end char and just samller string also true
        if (str.charAt(start) == str.charAt(end) && checkPallindromeSubstr(str, start + 1, end - 1)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "goodmom";
        if (checkPallindromeSubstr(str, 4, str.length() - 1)) {
            System.out.println("yes");
        } else {
            System.out.println("No");
        }

    }

}
