package com.Stack;

import java.util.List;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack {

    // implementing statck using the ArrayList
    private List<Integer> list;

    public Stack() {
        this.list = new ArrayList<Integer>();
    }

    public void push(int data) {
        list.add(data);
    }

    public void pop() {
        int size = list.size();
        if (size == 0) {
            System.out.println("Under flow exception!");
            return;
        }
        list.remove(size - 1);
    }

    public Object top() {
        int size = list.size();
        if (size == 0) {
            System.out.println("Under flow exception!");
            return new EmptyStackException();
        }

        return list.get(size - 1);
    }

    public boolean isEmpty() {
        return (list.size() == 0);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(String.format("current size of the stack is %s", stack.size()));

        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        // this line will throw exception
        System.out.println((int) stack.top());

        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is not empty");
        }

        System.out.println(String.format("Size %d", stack.size()));

    }
}
