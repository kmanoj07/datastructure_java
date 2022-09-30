package com.Array.CarryForward;

import java.util.ArrayList;

public class LeadersInArray {
    public static int getleftSideMax(int start, int end, int A[]) {
        int max = Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            if(A[i] > max){
                max = A[i];
            }
        }
        return max;
    }

    public static int leadersInArrCntOpt(int A[]) {
        int n = A.length;
        //considerring the A[0] is always a leader
        int lcnt = 1;
        int max = A[0];
        for(int i=1;i<n;i++){
            if(A[i] > max){
                max = A[i];
                lcnt ++;
            }
        }
        return lcnt;
    }

    public static int leadersInArrCnt(int A[]) {
        int n = A.length;
        //considerring the A[0] is always a leader
        int cnt = 1;
        for(int i=1;i<n;i++) {
            int  max = getleftSideMax(0, i-1, A);
            if(A[i] > max){
                cnt++;
            }
        }
        return cnt;

    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> leaders = new ArrayList<Integer>();
        int n = A.size();
        // rightmost element is always a leader.
        int max = A.get(n-1);
        // so add this element in leader list
        leaders.add(max);

        //looping from rigth to left with n-2 index as n-1 is already considered as leader
        for(int i = n-2 ; i>=0; i--) {
            if(A.get(i) > max) {
                max = A.get(i);
                leaders.add(A.get(i));
            }
        }
        return leaders;
    }
    

    public static int countagPairFromLR(String str) {
        int N = str.length();
        int aCount = 0;
        int ans = 0;

        for (int i=0;i<N;i++) {
            if(str.charAt(i) == 'a'){
                aCount  += 1;
            } else if(str.charAt(i) == 'g') {
                ans = ans + aCount;
            }
        }
        return ans;
    }

    public static int countagPairRL(String str) {
        int N = str.length();
        int gCount = 0; //carying this count of g
        int ans  = 0;

        //counting the g from left 
        for ( int i = N-1; i >=0 ; i--) {
            if(str.charAt(i) == 'g') {
                gCount += 1;
            } else if(str.charAt(i) == 'a') { // as soon  wee get the a we add gcount to initial ans
                ans = ans + gCount;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        // int A[] = new int[]{3, 2, 4, 5,2, 7, -1, 15};
        // int res = leadersInArrCntOpt(A);
        
        //System.out.println(res);
        // ArrayList<Integer> A = new ArrayList<Integer>();
        // A.add(16);
        // A.add(17);
        // A.add(4);
        // A.add(3);
        // A.add(5);
        // A.add(2);

        // ArrayList<Integer> res = solve(A);

        // for(int i=0;i<res.size();i++){
        //     System.out.print(res.get(i));
        // }
        String str = "adgagagfg";
        int pairCount = countagPairRL(str);
        System.out.println(pairCount);

    }
}
