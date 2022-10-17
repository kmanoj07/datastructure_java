package com.Sorting;

public class SortingBasic {

    public static int maxMod(int[] A) {
        int n = A.length;
        int mMod = Integer.MIN_VALUE;

        //for every valid pair get mod
        for(int i = 0; i<n; i++) {
           for (int j = i+1; j < n-1; j++) {
            int mod = (A[i] % A[j]);
            if(mod > mMod) {
                mMod = mod;
            }
           }
        }
        return mMod;
    }

    public static int kthsmallest(int[] A, int K) {
        int n = A.length;
        for (int i=0; i<K; i++) {
            //current min
            int min  = A[i];
            int idx = i;
            //get minimum at ithe pos
            for (int j=i; j < n; j++) {
                if(A[j] < min) {
                    idx = j;
                    min = A[j];
                }
            }
            //swap
            int temp = A[i];
            A[i] = min;
            A[idx]  = temp;
        }

        printArray(A);
        return A[K-1];
    }

    public static void printArray(int[] A) {
        for (int i : A) {
            System.out.print(i + " ");
        }System.out.println();
    }

    public static void mergeSort(int A[], int s, int e) {
        if(s == e) {
            return;
        }
        int m = (s + e) / 2;
        mergeSort(A, s, m);
        mergeSort(A, m+1, e);
        merge(A, s, m, e);
    }

    //merging two sorted sub array
    public static void merge(int[] A, int s, int m, int e) {
        int len = (e - s + 1);
        int ans[] = new int[len];

        int p1 = s, p2 = m+1, p3 = 0;

        while (p1 <= m && p2 <= e)  {
            if(A[p1] < A[p2]){
                ans[p3] = A[p1];
                p1 = p1 + 1;
                p3 = p3 +1;
            } else {
                ans[p3] = A[p2];
                p2 = p2 + 1;
                p3 = p3 + 1;
            }
        }

        while (p1 <= m) {
            ans[p3] = A[p1];
            p1 = p1 + 1;
            p3 = p3 + 1; 
        }

        while (p2 <= e) {
            ans[p2] = A[p2];
            p2 = p2 + 1;
            p3 = p3 + 1;
        }
    }

    public static int[] merge(final int[] A, final int[] B) {
        int n = A.length;
        int m = B.length;

        int p1 = 0, p2 = 0, p3 = 0;

        int ans[] = new int[n+m];

    
        while (p1 < n && p2 < m) {
            if(A[p1] < B[p2]) {
                ans[p3] = A[p1];
                p1 = p1 + 1;
                p3 = p3 + 1;
            } else {
                ans[p3] = B[p2];
                p2 = p2 + 1;
                p3 = p3 + 1;
            }
        }

        while (p1 < n) {
            ans[p3] = A[p1];
            p1 = p1 + 1;
            p3 = p3 + 1;
        }

        while (p2 < m)  {
            ans[p3] = B[p2];
            p1 = p2 + 1;
            p3 = p3 + 1;
        }

        return ans;
    }

    public static void main(String[] args)  {
        // int[] A = { 8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92 };
        // int res = kthsmallest(A, 9);
        // System.out.println(res);
        int A[] = {1, 2, 44, 3};
        int res = maxMod(A);
        System.out.println(res);
    }
}
