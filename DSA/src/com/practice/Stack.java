package com.practice;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Stack {
    public static int c = 0;
    public static Node h = null;

    public static void push(int data) {
        // create a new node
        Node newnode = new Node(data);
        newnode.next = h;
        h = newnode;
        c = c + 1;
    }

    public static void pop() {
        if(h == null) {
            System.out.println("The Stack is empty");
            return;
        } else {
            Node temp = h;
            h = h.next;
            temp.next = null;
            c = c-1;
        }
    }

    public static int top() {
        if(h == null){
            System.out.println("Stack is empty");
            return 0;
        } else {
            return h.data;
        }
    }

    public static int size() {
        return c;
    }

    public static boolean isEmpty() {
        if(c == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Stack.push(5);
        Stack.push(10);
        Stack.push(20);
        Stack.push(40);
        System.out.println(Stack.size());

        System.out.println(Stack.top());


        Stack.pop();

        System.out.println(Stack.top());

        Stack.pop();
        System.out.println(Stack.size());

        if(Stack.isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is not empty");
        }
    }
}

