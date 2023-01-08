package com.Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class CustomCampare implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        // finding the factor count
        int cnt1 = 1;
        int cnt2 = 1;
        for (int i = 1; i <= o1; i++) {
            if ((int) o1 % i == 0) {
                cnt1 = cnt1 + 1;
            }
        }
        for (int i = 1; i <= o2; i++) {
            if ((int) o2 % i == 0) {
                cnt2 = cnt2 + 1;
            }
        }
        // comparision
        if (cnt1 == cnt2) {
            return 0;
        } else if (cnt1 > cnt2) {
            return 1;
        } else
            return -1;
    }
}

public class SortingBasics {
    public static int inversionCount = 0;

    public static int cntNobleInteger(int[] A) { // when array contains the distinct ele
        int n = A.length;
        int cnt = 0;
        Arrays.sort(A);

        for (int i = 0; i < n; i++) {
            if (A[i] == i) {
                cnt = cnt + 1;
            }
        }
        return cnt;
    }

    public static void sortingFactor(int[] A) {
        List<Integer> list = new ArrayList<Integer>();
        IntStream val = Arrays.stream(A);
        val.forEach((data) -> {
            list.add(data);
        });
        Collections.sort(list, new CustomCampare());
        for (int i = 0; i < A.length; i++) {
            A[i] = list.get(i);
        }
    }

    public static int sumOfMaxOdAllSubseq(int[] A) {
        Arrays.sort(A);
        int ans = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            // fre denotes in how many subsequences the ith is max elem
            int freq = (1 << i);
            // contribution of each ans every array ele in the total sum of
            // maxOfallSubsequences
            ans = ans + (A[i] * freq);
        }
        return ans;
    }

    // 1. Bubble sort
    public static void bubbleSort(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            boolean iswap = false;
            for (int j = 0; j < n - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                    iswap = true;
                }
            }
            if (iswap == false) {
                break;
            }
        }
    }

    // 2. Count Sort
    public static void countSort(int[] A, int s, int e) {
        int n = A.length;
        // storing the freq of A[i]
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!hmap.containsKey(A[i])) { // not contain in hashmap
                hmap.put(A[i], 1);
            } else { // if alredy there
                hmap.put(A[i], hmap.get(A[i]) + 1);
            }
        }

        int k = 0;
        // iterating over the given range
        for (int i = s; i <= e; i++) {
            int freq = hmap.get(A[s]); // still takes at least 1 step for checking O(1) -- constant

            // print the i elem to the freq count
            // modify the original array itself to be sorted
            for (int j = 0; j < freq; j++) { // freq og i times
                A[k] = i;
                k++;
            }
        }

    }

    // 3. Selection sort
    public static void selectionSort(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int min = A[i];
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < min) {
                    min = A[j];
                    idx = j;
                }
            }
            // swap
            int temp = A[i];
            A[i] = A[idx];
            A[idx] = temp;
        }
    }

    // 4. Insertion sort
    // insertion step
    // lets n-1 data are sorted in A[N], make entire data sorted
    public static void insertionStep(int[] A) {
        int n = A.length;
        int scnt = 0;
        for (int i = n - 2; i >= 0; i--) {

            while (A[i] > A[i + 1]) {
                // swap i, i+1;
                int temp = A[i + 1];
                A[i + 1] = A[i];
                A[i] = temp;
                scnt += 1;
            }
        }
        System.out.println("Swap cnt " + scnt);
    }

    // lets say there are more than one element are not in its correct position
    // lets insert that element to its correct position
    public static void insertionSort(int[] A) {
        // considering the 1 ele is at sorted postion
        // lets start insertion step from i+1;
        int n = A.length;
        // unsorted ele
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] > A[j + 1]) {
                    // swap i, i+1;
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                } else { // if we are not doing any swapping do not continue the process starts form the
                         // next element to inser
                    break;
                }
            }
            // int k = i;
            // while (k > 0 && A[k] < A[k - 1]) {
            // // swap i, i+1;
            // int temp = A[k];
            // A[k] = A[k - 1];
            // A[k - 1] = temp;
            // k--;
            // }
        }
    }

    // 5. Merge Sort
    // Merging two sorted arrays
    // Given two sorted n, m ans merge into single sorted array A
    public static void mergeSort(int A[], int l, int h) {
        // base condition
        if (l == h) {
            return;
        }
        // divide the array
        int mid = (l + h) / 2;
        // System.out.println("mid of the array A " + mid);
        // printArray(A, l, mid);
        mergeSort(A, l, mid);
        // printArray(A, mid + 1, h);
        mergeSort(A, mid + 1, h);
        // Start mergign now
        merge(A, l, mid, h);
    }

    // merge two sorted array or sorted sub array
    public static void merge(int[] A, int s, int mid, int e) {
        // [s mid] ,[mid+1 e]
        int p1 = s;
        int p2 = mid + 1;
        int p3 = 0;
        // temp array to merge two sub array form s e
        int size = (e - s + 1);
        int[] temp = new int[size];

        while (p1 <= mid && p2 <= e) {
            // handling the equal value as well
            if (A[p1] <= A[p2]) {
                temp[p3] = A[p1];
                p1 = p1 + 1;
                p3 = p3 + 1;
            } else { // A[p1] >= A[p2]

                // count the inversion as we taking the data from the right side of the array to
                // temp
                int eleRemainOnLeftside = (mid - p1 + 1);
                inversionCount = inversionCount + (eleRemainOnLeftside);

                temp[p3] = A[p2];
                p2 = p2 + 1;
                p3 = p3 + 1;
            }
        }
        // copying the remaining array form P1
        while (p1 <= mid) {
            temp[p3] = A[p1];
            p1 = p1 + 1;
            p3 = p3 + 1;
        }

        while (p2 <= e) {
            temp[p3] = A[p2];
            p2 = p2 + 1;
            p3 = p3 + 1;
        }

        // for (int i = 0; i < temp.length; i++) {
        // System.out.print(temp[i] + ", ");
        // }
        // System.out.println();

        // copy the temp array sorted data to original array
        int i = 0;
        int j = s;
        while (i < temp.length) {
            A[j] = temp[i];
            i = i + 1;
            j = j + 1;
        }
    }

    public static void printArray(int A[], int s, int e) {
        for (int i = s; i <= e; i++) {
            System.out.print(A[i] + ", ");
        }
        System.out.println();
    }

    // count the inversion count
    // At the time of merging 2 sorted array cnt the inversions
    public static void inversionCnt(int[] A, int s, int e) {
        if (s == e) {
            return;
        }
        int mid = (s + e) / 2;
        // left side
        inversionCnt(A, s, mid);
        // right side
        inversionCnt(A, mid + 1, e);
        // merge step
        mergeTwoSortedArray(A, s, mid, e);
    }

    public static void mergeTwoSortedArray(int[] A, int s, int mid, int e) {
        int p1 = s;
        int p2 = mid + 1;

        int size = (e - s + 1);
        int[] temp = new int[size];
        int p3 = 0;

        while (p1 <= mid && p2 <= e) {
            if (A[p1] <= A[p2]) {
                temp[p3] = A[p1];
                p1 = p1 + 1;
                p3 = p3 + 1;
            } else {
                // count the inversion as we taking the data from the right side of the array to
                // temp
                int eleRemainOnLeftside = (mid - p1 + 1);
                inversionCount = inversionCount + (eleRemainOnLeftside);

                temp[p3] = A[p2];
                p2 = p2 + 1;
                p3 = p3 + 1;
            }
        }

        // copying the reamin element
        while (p1 <= mid) {
            temp[p3] = A[p1];
            p1 = p1 + 1;
            p3 = p3 + 1;
        }

        while (p2 <= e) {
            temp[p3] = A[p2];
            p2 = p2 + 1;
            p3 = p3 + 1;
        }

        // copy the temp array sorted data to original array
        // copying the temp data to original array
        for (int i = 0; i < (e - s + 1); i++) {
            A[i + s] = temp[i];
        }

        // int i = 0;
        // int j = s;
        // while (i < temp.length) {
        // A[j] = temp[i];
        // i = i + 1;
        // j = j + 1;
        // }

    }

    // 6. Quick Sort
    public static void quickSort(int[] A, int s, int e) {
        // base condition
        if (s >= e) { // if single ele do not do anything
            return;
        }
        int pivot = rearrange(A, s, e);
        System.out.println("I am inside");
        System.out.println("reference point is " + pivot);
        quickSort(A, s, pivot - 1);
        quickSort(A, pivot + 1, e);
    }

    // rearranging the data on the basis of a reference point / pivot point
    public static int rearrange(int[] A, int s, int e) {
        // lets considering A[0] as pivot / reference point
        // let the reference pint is A[s]
        int p1 = s + 1;
        int p2 = e;

        while (p1 <= p2) { // even if the p1 == p2 cont the process

            if (A[p1] <= A[s]) { // A[p1] is on correct pos
                p1 = p1 + 1;
            } else if (A[p2] > A[s]) {// A[p2] is at correct pos
                p2 = p2 - 1;
            } else {
                // swap
                int temp = A[p2];
                A[p2] = A[p1];
                A[p1] = temp;

                p1 = p1 + 1;
                p2 = p2 - 1;
            }
        }

        // swap A[0], A[p2]
        int temp = A[p2];
        A[p2] = A[s];
        A[s] = temp;

        return p2;
    }

    public static void main(String[] args) {
        // int[] A = { 10, 3, 8, 15, 6, 12, 2, 18, 7, 1 };
        // int h = (A.length - 1);
        // mergeSort(A, 0, h);

        // printArray(A, 0, A.length-1);
        // int[] B = { 3, 10, 6, 8, 2, 5 };
        // insertionSort(B);
        // printArray(B, 0, B.length - 1);

        // int[] A = { 10, 3, 8, 15, 6, 12, 2, 18, 7, 1 };
        // mergeSort(A, 0, A.length - 1);
        // printArray(A, 0, A.length-1);
        // System.out.println("Total inversion count in array A (i < j) ans A[i] > A[j]"
        // + inversionCount);

        // int[] B = { 3, 1, -4 };
        // int res = sumOfMaxOdAllSubseq(B);
        // System.out.println(res);

        // int[] z = { 10, 3, 8, 15, 6, 12, 2, 18, 7, 15, 14 };
        // quickSort(z, 0, z.length - 1);

        // int ref = rearrange(z, 0, z.length - 1);
        // System.out.println("The refence pint is " + ref);
        // printArray(z, 0, z.length - 1);

        int[] A = { 12, 9, 13, 1, 6 };
        sortingFactor(A);
        printArray(A, 0, A.length - 1);

    }
}
