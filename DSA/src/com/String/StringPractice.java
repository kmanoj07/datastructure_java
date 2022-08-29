package com.String;

import java.util.ArrayList;
import java.util.Arrays;

public class StringPractice {
    public static String solve(String A) 
    {
        //converting the A to StringBuilder
        StringBuilder sb = new StringBuilder(A);
        int n = sb.length();
        int s = 0;
        int e = n-1;
        while (s < e) {
            char temp = sb.charAt(e);
            
            sb.setCharAt(e, sb.charAt(s));
            sb.setCharAt(s, temp);
            s++;
            e--;
        }
        return sb.toString();
    }
    public static ArrayList<Character> convert_to_lower(ArrayList<Character> A) 
    {
        ArrayList<Character> lch = new ArrayList<>();
        int n = A.size();
        for (int i=0;i<n;i++) 
        {
            char ch = A.get(i);
            //if character uppercase than convert to lower
            // add to list
            if (ch >= 'A' && ch <= 'Z') 
            {
                char lowerCh = (char) (A.get(i) + 'a' - 'A');
                lch.add(lowerCh);

            }
            else 
            {
                //already lower case just add the character to list
                lch.add(A.get(i));
            }
        }
        return lch;
    }
    public static int isAlphaNumeric(ArrayList<Character> A) {

        int n  = A.size();
        int ans = 0;
        for (int i=0; i<n; i++) {
            char ch = A.get(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >='A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
                ans = 1;
            } else {
                ans = 0;
                break;
            }
        }
        return ans;
    }
    public static void printArrList(ArrayList<Character> list) 
    {
        int n = list.size();
        for (int i=0;i<n;i++) 
        {
            System.out.print(list.get(i) + " ");
        } System.out.println();

    }
    public static void main(String[] args) {
        //String str = "scaler";
        //String revStr = solve(str);
        //System.out.println(revStr);
        //ArrayList<Character> charArr = new ArrayList<Character>(Arrays.asList('S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'));
        //ArrayList<Character> resArr =  convert_to_lower(charArr);
        //printArrList(resArr);
        ArrayList<Character> arr = new ArrayList<>(Arrays.asList('S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'));
        int res = isAlphaNumeric(arr);
        System.out.println(res);
    }
}
