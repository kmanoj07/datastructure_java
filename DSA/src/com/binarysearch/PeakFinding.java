package com.binarysearch;

public class PeakFinding {
    //Searching in the rotated sorted array for target B (rotation is from last to start)
    public static int searchInRotatedSortedArray(int[] A, int B) {
        int n = A.length;
        //Rotate factor
        int k = rotateFact(A);
        int ans  = -1;

        if(A[0] > B) {
            //search on left side of rotate factor
            ans =  binarySearch(A, k, n-1, B);
        } else {
            ans =  binarySearch(A, 0, k-1, B);
        }
        return ans;
    }

    //Rotate fac = min of the array (it will tell how many times the array is rotated)
    public static int rotateFact(int[] A) {
        int n = A.length;
        int l = 0;
        int h = n-1;
        int ans = n;
        while (l <= h) {
            int mid = (l+h)/2;

            //the mid on right side than go to left to find the minimum
            if (A[0] > A[mid]) {
                ans = mid;
                h = mid - 1;
            } else { // A[0] < A[mid] //That means the mid will fall on left side move to right side to get mim
                l = mid + 1;
            }
        }
        return ans;
    }

    public static int minTimeToCompleteNTask(int N, int K, int time[]) {

        // Minimum time to complete all task
        int l = maxOfArray(time);
        // Maximum time to complete all the task
        int h = sumOfArray(time);

        int ans = h; // We have to minimise the time

        while (l <= h) {

            int mid = (l + h) / 2;
            // Check if we can finish the task in m time if yes
            if (check(N, K, time, mid) == true) {
                // we are able to complete the task in mid time
                // that will be the possible answer
                ans = mid;
                // go to left for min time (or better answer)
                h = mid - 1;
            } else { // if we are able to finish owr task in mid time, it means less than mid < mid
                     // will also not work
                l = mid + 1;
            }
        }

        return ans;
    }

    //can we complete all task in given mid time
    public static boolean check(int N, int k, int time[], int mid) {
        int task = 0;
        int c = 0;
        for (int i=0; i<N; i++) {
            //assign the ith task to 
            task = task + time[i];
            if (task  > mid) {
                c = c + 1; //allocate the task to new worker
                task = time[i]; // reset the task 
            }
            //if all task are allocated to k worker and task still remains
            if (c == k && task > 0) {
                return false;
            }
        }
        return true;
    }

    public static int maxOfArray(int time[]) {
        int ans = Integer.MIN_VALUE;
        int n = time.length;
        for (int i=0;i<n;i++) {
            if (time[i] > ans) {
                ans = time[i];
            }
        }
        return ans;
    }

    public static int sumOfArray(int time[]) {
        int sum = 0;
        int n = time.length;
        for (int i=0;i < n; i++) {
            sum  = sum + time[i]; 
        }
        return sum;
    }

    public static int findInRotatedSortedArray(int[] A, int k) {
        int n = A.length;
        int l = 0;
        int h = n - 1;

        if (n == 1) {
            if (A[0] == k) {
                return 0;
            } else {
                return -1;
            }
        }
        while (l <= h) {
            int mid = (l + h) / 2;

            if (A[mid] == k) {
                return mid;
            }
            if (A[mid + 1] < A[mid] && k < A[mid]) {
                l = mid + 1;
            } else { // A[mid + 1] > && k > A[mid]
                h = mid - 1;
            }
        }

        return -1;
    }

    public static int findUniqueEle(int[] A) {
        int n = A.length;

        // edge cases to handle
        if (n == 1) {
            return A[0];
        }

        if (A[0] != A[1]) {
            return A[0];
        }

        if (A[n - 1] != A[n - 2]) {
            return A[n - 2];
        }

        int l = 0;
        int h = n - 1;

        while (l <= h) {

            int mid = (l + h) / 2;

            if (A[mid] != A[mid - 1] && A[mid] != A[mid + 1]) {
                return A[mid];
            }

            if (A[mid - 1] == A[mid]) {
                mid = mid - 1;
            }

            if (mid % 2 == 0) {
                l = mid + 2;
            } else {
                h = mid - 1;
            }
        }

        return -1;
    }

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
        // int[] A = { 4, 5, 6, 7, 0, 1, 2, 3 };
        // int k = 4;
        // int res = findInRotatedSortedArray(A, k);
        // System.out.println(res);

        // int[] N = {3, 5, 1, 7, 8,2,5,3,10,1,4,7,5,4,6};
        // int w = 4;
        // int res = minTimeToCompleteNTask(15, w, N);
        // System.out.println(res);
        int[] A  = {1,2,3,5,6,7,8};
        int res = searchInRotatedSortedArray(A, 2);
        System.out.println(res);
    }
}
