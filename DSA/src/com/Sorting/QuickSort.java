package com.Sorting;


public class QuickSort {

    public static void quickSort(int[] A, int s, int e) {

        //base condition
        if (s >= e) {
            return;
        }
        
        //rearrage on the bases of the reference taking s
        int p = rearrange(A, s, e);

        //after rearrage we will sort left part
        quickSort(A, s, p-1);
        quickSort(A, p+1, e);
    }

    public static int rearrange(int A[], int s , int e) {
        int p1 = s+1;
        int p2 = e;

        if(A[p1] <= A[s]) {
            p1 = p1 + 1;
        } else if (A[p2] > A[s]) {
            p2 = p2 + 1;
        } else {
            //both p1 and p2 are not there correct position
            //swpa(A[p1], A[p2])
            int temp = A[p1];
            A[p1] = A[p2];
            A[p2] = temp;
        }

        //now swap the s, p2
        int temp = A[s];
        A[s] = A[p2];
        A[p2] = temp;

        return p2;
    }
    public static void main(String[] args) {

    }
}
