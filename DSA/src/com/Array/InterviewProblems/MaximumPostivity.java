package com.Array.InterviewProblems;

import java.util.ArrayList;

public class MaximumPostivity {
   
    public static ArrayList<Integer> solve(int[] A) {
        int n = A.length;
        int maxSubArraysize = Integer.MIN_VALUE;
        int minIndex = Integer.MAX_VALUE;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        for (int i =0; i < n; i++ ) {
            for (int j=i; j < n ;j++) {
                ArrayList<Integer> nList = new ArrayList<>();
                for (int k=i;k<=j; k++) {
                   nList.add(A[k]);
                }
                boolean isPos = true;
                for(int m=0;m<nList.size();m++) {
                    if(nList.get(m) < 0){
                         isPos = false;
                         break;
                    }
                }
                if(isPos){
                    int len = nList.size();
                    if (len >= maxSubArraysize) {
                        maxSubArraysize = len;
                        ans.add(nList);
                    }
                }
            }
        }

        print(ans);
        int maxSize = Integer.MIN_VALUE;
        int index = Integer.MAX_VALUE;
        ArrayList<Integer>  a = new ArrayList<>();
        for (int i = 0; i < ans.size(); i++) {
            int size = ans.get(i).size();
            if (size > maxSize && i < index) {
                maxSize = size;
                index = i;
            }
            if (size >= maxSize && i < index) {
                for (int j = 0; j< ans.get(i).size(); j++) {
                    a.add(ans.get(i).get(j));
                }
            }
        }
        return a;
    }

    public static void print(ArrayList<ArrayList<Integer>> arr) {
        for (int i=0;i<arr.size();i++) {
            for (int j=0;j<arr.get(i).size();j++) {
                System.out.print(arr.get(i).get(j) + ", ");
            } System.out.println();
        }
    }

    public static void printArr(ArrayList<Integer> list) {
        int n = list.size();
        for (int i=0;i<n;i++) {
            System.out.print(list.get(i) + " ");
        } System.out.println();
    }

    public static int s() {
        String bNum = "";
        for (int i=0;i<3;i++) {
            bNum += "1";
        }
        for(int j=0;j<2;j++) {
            bNum += "0";
        }
      return Integer.parseInt(bNum, 2);
    }

    public static void main(String[] args) {
         int[] arr = new int[] {5, 6, -1, 7, 8};
         ArrayList<Integer> list =  solve(arr);
        printArr(list);
        //System.out.println(s());
    }
}
