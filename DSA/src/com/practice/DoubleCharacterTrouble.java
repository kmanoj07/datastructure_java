package com.practice;

public class DoubleCharacterTrouble {
    public static void main(String[] args){
        String str = "abbbe";
        java.util.Stack<Character> stack = new java.util.Stack<Character>();

        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(stack.isEmpty()) {
                stack.push(ch);
            } else {
                if(stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        //iterate over the stack
        StringBuilder ans = new StringBuilder();
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                ans.append(stack.pop());
            }
        }

        //reverse the string
        System.out.println(ans.reverse());
    }
}
