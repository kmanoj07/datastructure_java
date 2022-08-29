package com.Array.PrefixSum;

public class SpecailIndex {

    public static int SpecailIndexCountOptimized(int[] A) {
        int n = A.length;
        int cnt = 0;
        //Creat PFevenIndex
        int PFsumevenIndex[] = new int[n];
        PFsumevenIndex[0] = A[0];
        for(int i=1;i<n;i++){
            if(i%2 == 0){
                PFsumevenIndex[i] = PFsumevenIndex[i-1] + A[i];
            } else  {
                PFsumevenIndex[i] = PFsumevenIndex[i-1];
            }
        }
        //Creat PFOddIndex
        int PFoddIndex[] = new int[n];
        PFoddIndex[0] = 0;
        for(int i=1;i<n;i++){
            if(i%2 != 0){
                PFoddIndex[i] = PFoddIndex[i-1] + A[i];
            } else  {
                PFoddIndex[i] = PFoddIndex[i-1];
            }
        }
        
        for(int i=0;i<n;i++){
            int Se = 0;
            int So = 0;
            if(i == 0){
                Se = PFsumevenIndex[n-1] - PFsumevenIndex[i];
                So = PFoddIndex[n-1] - PFoddIndex[i];
            } else {
                Se = PFsumevenIndex[i-1] + PFoddIndex[n-1] - PFoddIndex[i]; 
                So = PFoddIndex[i-1] + PFsumevenIndex[n-1] - PFsumevenIndex[i];
            }

            if(Se == So){
                System.out.println("Special Index " + i);
                cnt++;
            }

        }
        return cnt;
    }

    //TC - O(N^2)
    public static int SpecailIndexcount(int[] A) {
        int n = A.length;
        int cnt = 0;

        for(int i=0;i<n;i++){
            //create a copy array if size n-1
            int cpy[] = new int[n-1];
            int ptr = 0;
            //{3,2,7,6,-2};
            // creating temporary array and cpying the original array value excluding current index value
            for(int j=0;j<n;j++){  
                if(j != i){
                    cpy[ptr] = A[j];
                    ptr++;
                }
            }

            // for(int k=0;k<cpy.length;k++){
            //     System.out.print(cpy[k] + " ");
            // }System.out.println();

            int Se = getSumofAllEvenIndex(0, cpy.length-1, cpy);// we can do it with for loop 
            int So = getSumofAllOddIndex(0, cpy.length-1, cpy); // we can do it with for loop.

            if(Se == So){
                System.out.println("Special Index " + i);
                cnt++;
            }
        }

        return cnt;
    }

    public static int getSumofAllEvenIndex(int L, int R, int[] A) {
        //create a PFeindexsum
        int n = A.length;
        int[] PFe = new int[n];
        PFe[0] = A[0];
        for(int i=1;i<n;i++){
            if(i%2 == 0){
                PFe[i] = PFe[i-1] + A[i];
            } else {
                PFe[i] = PFe[i-1];
            }
        }

        if(L==0){
            return PFe[R];
        } else {
            return PFe[R] - PFe[L-1];
        }
    }

    public static int getSumofAllOddIndex(int L, int R, int[] A) {
        int n = A.length;
        int[] PFo = new int[n];
        PFo[0] = 0;
        for(int i=1;i<n;i++){
            if(i%2 != 0){
                PFo[i] = PFo[i-1] + A[i];
            } else {
                PFo[i] = PFo[i-1];
            }
        }

        if(L==0){
            return PFo[R];
        } else {
            return PFo[R] - PFo[L-1];
        }
        //brute force approach
        // int sum = 0;
        // for(int i=L;i<=R;i++){
        //     if(i%2 !=0 ){
        //         sum += A[i];
        //     }
        // }
        // return sum;
    }


    public static void main(String[] args) {
        // int A[] = {3,2,1,6,-3,2,8,4};
        // int L = 1;
        // int R = 4;
        // int sumEindex = getSumofAllEvenIndex(L, R, A);
        // System.out.println(sumEindex);

        // int sumOindex = getSumofAllOddIndex(L, R, A);
        // System.out.println(sumOindex);

        int A[] = {1, 2, 3, 4, 5, 6, 13, 1, 2, 3, 4, 5, 6};
        int cntSpecialIndex = SpecailIndexCountOptimized(A);
        System.out.println(cntSpecialIndex);

    }
}
