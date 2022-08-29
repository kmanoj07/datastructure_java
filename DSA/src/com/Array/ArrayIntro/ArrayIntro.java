package com.Array.ArrayIntro;

public class ArrayIntro {

    public static int goodPair(int[] A, int B) {
        int N = A.length;
        for(int i=0;i<N-1;i++){
            for(int j=i+1; j<N; j++){
                if(A[i]+A[j] == B){
                    return 1;
                }
            }
        }
        return 0;
    }
    public static int solve(String  s) {
        int n = s.length();
        int cnt = 0;
        int max = Integer.MIN_VALUE;

        for (int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '1'){
                cnt++;
            }
            else if (ch == '0') {
            }
        }
        return max;
    }

    public static int count(int n) {
        int cnt = 0;
        while(n > 0) 
        {
            int bit = (n) & 1; 
            if(bit == 1) { cnt++; } 
            n = n>>1;
        }
        return cnt;
    }
    public static void main(String[] args)
    {
        // int[] arr = {2,3,4,2,2,3};
        // int res = goodPair(arr, 7);
        // System.out.println(res);
       // String str = "11010110000000000";
        //int res = solve(str);
        //System.out.println(res);
        System.out.println(count(27));
    }

}
