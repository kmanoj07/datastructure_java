package com.String;

import java.util.ArrayList;
import java.util.Collections;

public class ChangeCharacter {
    public static int solve(String A, int B) {
        // create a count array
        int[] count = new int[26];
        for (int i = 0; i < A.length(); i++) {
            int index = A.charAt(i) - 97;
            count[index]++;
        }
        printArr(count);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                list.add(count[i]);
            }
        }

        Collections.sort(list);
        int ans = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= B) {
                B = B - list.get(i);
                ans--;
            }
        }

        return ans;

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " -> " + arr[i]);
        }
    }

    public static int solve1(String A, int B) {
        int[] countingArray = new int[26];
        for (int i = 0; i < A.length(); i++) {
            countingArray[A.charAt(i) - 97]++;
        }
        ArrayList<Integer> C = new ArrayList<Integer>();
        for (int i = 0; i < 26; ++i) {
            if (countingArray[i] > 0) {
                C.add(countingArray[i]);
            }
        }
        Collections.sort(C);
        int ans = C.size();
        for (int i = 0; i < C.size(); ++i) {
            if (C.get(i) <= B) {
                B -= C.get(i);
                ans--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "abcabbccd";
        // solve(str);
        System.out.println(solve1(str, 3));
    }
}
