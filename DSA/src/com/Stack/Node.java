package com.Stack;

public class Node {
    // instance variable
    private int data;
    private Node next;

    // class variable
    private static Node head = null;
    private static int size = 0;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public static Node push(Node head, int data) {
        if (head == null) {
            Node newnode = new Node(data);
            head = newnode;
            size++;
            return head;
        }
        Node newnoNode = new Node(data);
        newnoNode.next = head;
        head = newnoNode;
        size++;
        return head;
    }

    public static void pop() {
        if (head == null && size() == 0) {

            System.out.println("Stack is empty");
            return;
        }

        Node temp = head;
        head = head.next;
        size--;
        temp.next = null; // Garbage collector will collect this Object which is there in memory, it has
                          // not been reference
        temp = null; // orphan object
    }

    public static boolean isEmpty() {
        return (size() == 0);
    }

    public static int size() {
        return size;
    }

    public static Node top() {
        if (head == null && size() == 0) {
            System.out.println("Stack is empty");
            return null;
        }

        return head;
    }

    public static void main(String[] args) {
        /**
         * let create ArrayList implementation of the Stack
         */

        System.out.println("Current Size " + size + " H -> " + head);

        // push to stack
        head = Node.push(head, 50);
        System.out.println("Current Size " + size + " H -> " + head);

        head = Node.push(head, 60);
        System.out.println("Current Size " + size + " H -> " + head);

        head = Node.push(head, 70);
        System.out.println("Current Size " + size + " H -> " + head);

        head = Node.push(head, 80);
        System.out.println("Current Size " + size + " H -> " + head);

        if (Node.isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is not empty");
        }

        // pop
        Node.pop();
        System.out.println("Current Size " + size + " H -> " + head);

        Node.pop();
        System.out.println("Current Size " + size + " H -> " + head);

        Node.pop();
        System.out.println("Current Size " + size + " H -> " + head);

        // Node.pop();
        // System.out.println("Current Size " + size + " H -> " + head);

        // Node.pop();
        // System.out.println("Current Size " + size + " H -> " + head);

        Node topNode = Node.top();

        if (topNode != null) {
            System.out.println("Current Size " + size + " H -> " + topNode.data);
        } else {
            System.out.println("Empty stack");
        }

    }
}
