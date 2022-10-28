package com.Math;

public class PrimeNumber {
    public static boolean isPrime(int N) {
        int cnt = 0;
        for (int i = 1; i*i <= N; i++) {

            if (N % i == 0) {
                if (i == N / i) {
                    cnt = cnt + 1;
                } else {
                    cnt = cnt + 2;
                }
            }
        }
        if(cnt == 2){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            if(isPrime(i) == true) {
                System.out.println(i+ ", ");
            }
        }
    }
}
