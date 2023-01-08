package com;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {

    public static int size = 0;

    // 1 <= position <= size;
    public static void insertAtPosition(Node headNode, int position, int data) {
        if (position == 1) {
            if(headNode != null) {
                Node current = headNode;
                for (int i= 1; i < position -1; i++) {
                    current = current.next;
                }
                Node newnode = new Node(data);
                newnode.next = current.next;
                current.next = newnode;

            } else {
                System.out.println("Empty Linked list");
                return;
            }

        } else if (position == (size + 1)) {
            Node current = headNode;
            for (int i = 1; i<position-1; i++) {
                current = current.next;
            }
            Node newnode = new Node(data);
            newnode.next = current.next;
            current.next = newnode;
        } else {
            return;
        }
        size = size + 1;
    }

    // deleta from given pos
    // 1 <= position <= size
    public static void deleteAtposition(Node headeNode, int position, int data) {
        if (position == 1) {
            if (headeNode != null) {
                headeNode = headeNode.next;
            } else if (position > 1 && position <= size) {
                Node current = headeNode;
                for (int i = 1; i < position - 1; i++) {
                    current = current.next;
                }
                Node temp = current.next;
                current.next = temp.next;
            }
            else {
                System.out.println("Empty Linked List ...");
                return;
            }
        }

        size = size - 1;
    }

    public static void printll(Node headNode) {
        Node temp = headNode;
        if(temp == null) {
            System.out.println("Empty Linked List ...");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }System.out.println();
    }

    public static Node insert_at_head(Node node, int data) {
        if (node == null) {
            Node newnode = new Node(data);
            newnode.next = node;
            node = newnode;
            return node;
        } else {
            Node newnode = new Node(data);
            newnode.next = node;
            node = newnode;
            return node;
        }
    }

    public static Node insert_at_tail(Node node, int data) {

        if (node == null) {
            Node newnode = new Node(data);
            node = newnode;
            return node;
        } else {
            // create a new node
            Node newnode = new Node(data);
            node.next = newnode;
            return newnode;
        }
    }

    public static void print(Node node) {
        if (node == null) {
            System.out.println("Linked list is empty");
            return;
        } else {
            Node temp = node;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Node head = insert_at_tail(null, 5);
        // inserting at tail
        // Node node1 = insert_at_tail(head, 10);
        // Node node2 = insert_at_tail(node1, 20);
        // Node node3 = insert_at_tail(node2, 30);
        // Node node4 = insert_at_tail(node3, 40);
        // Node node5 = insert_at_tail(node4, 50);

        // inserting at head of the Linked list
        // Node head = insert_at_head(null, 5);
        // Node node1 = insert_at_head(head, 10);
        // Node node2 = insert_at_head(node1, 20);
        // Node node3 = insert_at_head(node2, 30);
        // Node node4 = insert_at_head(node3, 40);
        // Node node5 = insert_at_head(node4, 50);

        // print(node5);

        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt();

        int i = 1;

        while (i <= 10) {
            System.out.println(num * i);
            i = i + 1;
        }



    }
}
