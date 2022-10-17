package com.binarysearch;

public class PeakFinding {
    
    // searching inside the matrices
    // soreted matrices row wise
    // first element of each row is greater than the last element of previous row
    public static int searchMatrices(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;
        int l = 0;
        int h = ((n * m) - 1);

        while (l <= h) {
            int mid = (l + h) / 2;

            int i = mid / m;
            int j = mid % m;

            if (A[i][j] == B) {
                return 1;
            } else if (A[i][j] < B) {
                // go to right
                l = mid + 1;
            } else { // A[i][j] > B
                // go to left
                h = mid - 1;
            }
        }

        // target not found
        return 0;

    }

    public static int binarySearch(int[] A, int s, int e, int B) {

        int l = 0;
        int h = e;

        while (l <= h) {
            int mid = (h + (h - l)) / 2;

            if (A[mid] == B) {
                return mid;
            } else if (A[mid] > B) {
                // go to left
                h = mid - 1;
            } else { // A[mid] < B
                // go to right
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int findLocalMinima(int[] A) {
        int n = A.length;
        int l = 0;
        int h = n - 1;

        if (n == 1) {
            return A[0]; // lower elem
        }

        while (l <= h) {

            int mid = (l + h) / 2;

            if (A[mid - 1] > A[mid] && A[mid] < A[mid + 1]) {
                return A[mid];
            } else if (A[mid - 1] < A[mid]) {
                // got to left
                h = mid - 1;
            } else { // A[mid + 1] < A[mid]
                // go to right
                l = mid + 1;
            }

        }

        return -1;

    }

    // finding a peak element
    public static int findPeak(int[] A) {
        int n = A.length;
        if (n == 1) {
            return A[0];
        }

        int l = 0;
        int h = n - 1;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (mid == 0) {
                return Math.max(A[mid], A[mid + 1]);
            } else if (mid == n - 1) {
                return Math.max(A[mid], A[mid - 1]);
            }

            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return A[mid];
            } else if (A[mid - 1] > A[mid]) {
                // go to left
                h = mid - 1;
            } else { // A[mid+ 1] > A[mid]
                // go to right
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
