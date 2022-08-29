package com.Array.subarrays;

public class SubArray {
    public static void printArray(int[] A) {
       for(int i=0;i<A.length;i++){
        System.out.print(A[i]);
       }System.out.println();
       System.out.println();
    }
    public static void printAllSubArray(int[] A) {
        int n = A.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                //i satart and j end
                for(int k=i;k<=j;k++){
                    System.out.print(A[k]);
                }System.out.println();
            }

        }
        System.out.println();
    }
    public static void printSumofSubArrayStartAndEndIndex(int[] A) {
        int n = A.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum = 0;
                for(int k = i; k<=j; k++){
                    sum = sum + A[k];
                }
                System.out.println(sum);
            }
        }

    }
    public static void printTotalSumofSubArray(int[] A) {
        int n = A.length;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum = sum + A[j];
                System.out.print(sum + ", ");
            }System.out.println();
            
        }
    }
    public static void printSumofSubArrayPrefixSum(int[] A) {
       System.out.println("Sub array sum using prefix sum");
        int n = A.length;
       
       int[] PF = new int[n];
       PF[0] = A[0];
       for(int i=1;i<n;i++){
        PF[i] = PF[i-1] + A[i];
       }

       for(int i =0;i<n ;i++){
        for(int j=i;j<n;j++){
            //i start j end
            int sum = 0;
            if(i == 0){
                sum = PF[j];
            } else {
                sum = PF[j] - PF[i-1];
            }
            System.out.print(sum + ", ");
        }System.out.println();
       }
    }



    public static void printSumofSubArrayAccumulatingSum(int[] A) {
        int n = A.length;
        int total = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum = sum + A[j];
                total += sum;
            }
        }
        System.out.println("Total sum = " + total);
    }
    public static int getSumofAllSubArraySumsopt(int[] A) {
        System.out.println("Sums of all sub array sum");
        int total = 0;
        int n = A.length;
        
        for(int i=0;i<n;i++){
            int freq = (i+1) * (n-i);
            total += A[i] * (freq);
        }


        return total;
    }

    public static int maxSumSubArray(int[] A, int B) {
        int n = A.length;
        long max = -10000000;
       
        for(int i=0;i<n;i++){
            long subarraySum = 0;
            for(int j=i;j<n;j++){
                subarraySum += A[j];
                if(subarraySum <= B &&  subarraySum > max){
                    max = subarraySum;
                }
            }
          
        }
        if(max > 0) {
            return (int) max;
        } else {
            return 0;
        }
    }

    public static int leastAvgOfSubarrofKSize(int[] A, int K) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        
        //size sub arry 
        int n = A.length;

        //creating PF array to hold the sum
        int[] PF = new int[n];
        PF[0] = A[0];
        for(int i=1;i<n;i++){
            PF[i] = PF[i-1] + A[i];
        }

        for(int i=0; i<=n-K; i++){
            int sum = 0;
            if(i == 0){
                sum = PF[i+K-1];
            } else {
                sum = PF[i+K-1] - PF[i-1];
            }
            if(sum < min){
                min = sum;
                index = i;
            }
        }
        return index;
    }

    // A and K are non negative int
    public static int countSubArrSumLessthanK(int[] A, int B) {
        int cnt = 0;

        //create a PFsum array to hold the sum of the A till the ith index
        int n = A.length;
        int[] PFsum = new int[n];
        PFsum[0] = A[0];
        for(int i=1;i<n;i++){
            PFsum[i] = PFsum[i-1] + A[i];
        }

        
        for(int i= 0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum = 0;
                if(i==0) {
                    sum = PFsum[j];
                } else {
                    sum = PFsum[j] - PFsum[i-1];
                }
                if(sum < B) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static int googSubArray(int[] A, int B) {
        int cnt = 0;

        //create a PFsum array to hold the sum of the A till the ith index
        int n = A.length;
        int[] PFsum = new int[n];
        PFsum[0] = A[0];
        for(int i=1;i<n;i++){
            PFsum[i] = PFsum[i-1] + A[i];
        }

        for(int i= 0;i<n;i++){
            for(int j=i;j<n;j++){
                int len = j - i + 1;
                int sum = 0;
                if(i==0) {
                    sum = PFsum[j];
                } else {
                    sum = PFsum[j] - PFsum[i-1];
                }
                //any one condition satisfy if elseif
                if(len % 2 == 0 && sum < B) {
                    cnt++;
                } else if (len % 2 != 0 && sum > B) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
     public static void main(String[] args) {
        int[] A = new int[] {6, 8, -1, 7};
        printArray(A);
        printAllSubArray(A);
        printSumofSubArrayStartAndEndIndex(A);
        printTotalSumofSubArray(A);
        printSumofSubArrayPrefixSum(A);
        printSumofSubArrayAccumulatingSum(A);
        int res = getSumofAllSubArraySumsopt(A);

        System.out.println(res);

        System.out.println("------------------------");
        int[] Arr = {1, 2, 4, 4, 5, 5, 5, 7, 5};
        int maxsumSubarrayres= maxSumSubArray(Arr, 14);
        System.out.println("Maximum subarray sum " + maxsumSubarrayres) ;

        //Least avg of sub array of k size
        int[] arr = {3, 7, 90, 20, 10, 50, 40};
        int K = 3;
        int startindex = leastAvgOfSubarrofKSize(arr, K);
        System.out.println("Strating index " + startindex);

        // int[] arrary = {2, 5, 6};
        // int B = 10;
        // int rest = countSubArrSumLessthanK(arrary, B);
        // System.out.println("The count is " + rest);
        int[] array = {13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9};
        int B = 65;
        int cnt = googSubArray(array, B);
        System.out.println(cnt);
    }
}
