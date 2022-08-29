package com.Array.CarryForward;

public class CLosestMinMax {

    public static int getMax(int A[]) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            if(A[i] > max){
                max = A[i];
            }
        }
        return max;
    }
    public static int getMin(int A[]) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++){
            if(A[i] < min){
                min = A[i];
            }
        }
        return min;
    }

    public static int closestMinMaxsubArrLenOpt(int A[]) {
        int n = A.length;
        int minLen = n;
        int min = getMin(A);
        int max = getMax(A);

        int maxi =-1;
        int mini =-1;

        if(max == min){
            return 1;
        }

        for(int i=n-1; i>=0; i--){
            if(A[i] == max){
                maxi = i;
                if(mini != -1){
                    int len = mini - i + 1;
                    if(len < minLen){
                        minLen = len;
                    }
                }
            }
            if(A[i] == min){
                mini = i;
                if(maxi != -1){
                    int len = maxi - i + 1;
                    if(len < minLen){
                        minLen = len;
                    }
                }
            }
        }

        return minLen;

    }

    public static int closestMinMaxsubArrLen(int A[]) {
        //brute force approach
        int n = A.length;
        int minLen = n;
        int min = getMin(A);
        int max = getMax(A);

        if(max == min){
            return 1;
        }

        for(int i=0;i<n;i++){
            if(A[i] == max){
                //min index
                for(int j=i+1; j<n;j++){
                    if(A[j] == min){
                        int len = j-i+1;
                        if(len < minLen){
                            minLen = len;
                        }
                        break;
                    }
                }
            }
            if(A[i] == min) {
                //max index
                for(int j=i+1;j<n;j++){
                    if(A[j] == max){
                        int len = j-i+1;
                        if(len < minLen){
                            minLen = len;
                        }
                        break;
                    }
                }
            }
        }
        return minLen;
    }
    public static void main(String[] args) {
        int A[] = {814, 761, 697, 483, 981};
        int res = closestMinMaxsubArrLenOpt(A);
        System.out.println(res);
    }
}
