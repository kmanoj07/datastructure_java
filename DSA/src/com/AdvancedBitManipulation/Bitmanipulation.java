package com.AdvancedBitManipulation;

import java.util.HashMap;

public class Bitmanipulation {


    public static int setXandYCont(int x, int y) {
        int lastPos = x + y;
        int num = 0;
        // for (int i = y; i < lastPos; i++) {
        //     num  = num  + (1 << i);
        // }     

        //Contineous 1
        // (1 << x) means pow(2, X)
        // contenouws 0
        // << y
        return  ((1 << x) - 1) << y;
    }

    public static int setIthBitOfBinary(int N, int pos) {
        N  = N | (1 << pos); // 1 << i == 2^i or pow(2, i) 
        return N;
    }

    //time complexity depends upon the data type size
    // Int - 32 bits -- iteration
    // long - 63 bit --iteration
    //brute force
    public static int countBitIterative(int N) {
        int count = 0;
        for (int i=0; i < 32; i++) {
            //check in N, i bit is set or not
            if(((N >> i) & 1 ) == 1) {
                count++;
            }
        }
        return count;
    }
    

    //TC O(logN)
    //SC O(1)
    public static int countSetBits(int N) {
        int count  =  0;
        while (N > 0) {
            //check the set bit at oth pos
            if((N & 1) == 1) {
                count++;
            }

            N = N >> 1;
        }
        return count;
    }

    //convert the number to its binary
    public static String convertDecimalToBinary(int N) {
        //devide the number by 2 and collect the remainder
        StringBuilder binaryString = new StringBuilder();

        //dividing by 2 N >> 1
        //0 > 0 - false - loop stop N = 0 
        while (N > 0) {
            //divide the number by 2 to get the reminder
            int digit = (N % 2);
            binaryString.append(digit);
            //update the number by dividing it by 2
            N = N >> 1;
        }

        //reverse the binaryString string builder obj and conver to its string representaion
        return  binaryString.reverse().toString();
    }

    //SC O(1) and TC O(1)
    public static boolean checkSetBit(int N, int pos) {
        //Bit set means at that position the bit =1
        //Bit unset means at that position the bit = 0
        if(((N >> pos) & 1) == 1) {
            return true;
        } else {
            return false;
        }
    }

    //SC O(N) HashMap TC O(N)
    public static int getUnique(int A[]) {
        int N = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = -1;
        
        for(int i=0; i<N; i++){
            if(!map.containsKey(A[i])){
                map.put(A[i], 1);
            } else {
                map.put(A[i], map.get(A[i]) + 1);
            }
        }

        for (Integer key: map.keySet()) {
            if(map.get(key) == 1) {
                ans = key;
                return ans;
            }
        }

        return ans;
    }
 
    public static int unique(int A[]) {
        int N = A.length;

        //get XOR of entire array
        int ans  = 0;
        for (int i=0; i<N; i++) {
            ans = ans ^ A[i];
        }
        
        return ans;
    }

    public static void main(String[] args) {
        // int A[] = {10,10,12,12,4,4,1,1,90,90,5};
        // int ans  = getUnique(A);
        // System.out.println(ans);


        int N = 10;
        String binaryRes = convertDecimalToBinary(N);
        System.out.println(binaryRes);

        System.out.println(countSetBits(27));

        System.out.println(setIthBitOfBinary(23, 2));

        System.out.println(setXandYCont(2, 4));
    }
}
