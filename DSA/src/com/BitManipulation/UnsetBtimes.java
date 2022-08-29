package com.BitManipulation;

public class UnsetBtimes 
{

    public static int checkIthBit(int N, int i) {
        if ((N & (1 << i)) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
    public static int unsetBits(int A, int B) {
       for (int i=0; i<B; i++) {
            if(checkIthBit(A, i) == 1){
                A = A ^ (1 << i);
            }
       }
       return A;
    }
    
    public static int setIthBit(int A, int i) {
        return A | (1 << i);
    }

    public static long countSubArrWithBitwiseOr(int A, int[] B) {
        long cnt = 0;
        for (int i=0; i<A; i++) {
            for(int j=i; j<A; j++){
                boolean res = false;
                for(int k=i; k<=j; k++){
                    if(B[k] == 1) {
                        res = true;
                        break;
                    }
                }
                if(res == true){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int A = 93;
        int B = 4;
        int res = unsetBits(A, B);
        System.out.println(res);

        int num = 4;
        int i = 1;
        res = setIthBit(num, i);
        System.out.println(res);
    }
}
