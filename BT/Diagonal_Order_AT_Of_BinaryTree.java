package BT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Diagonal_Order_AT_Of_BinaryTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(20);
        root.left.left = new Node(60);
        root.left.right = new Node(50);
        root.right.left = new Node(70);
        root.right.right = new Node(90);

        Diagonal_Order_AT_Of_BinaryTreeHelper(root);
    }

    public static void Diagonal_Order_AT_Of_BinaryTreeHelper(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i = i + 1) {
                Node n = q.remove();

                while (n != null) {
                    if (n.right != null) {
                        q.add(n.right);
                    }
                    System.out.println(n.data);
                    n = n.left;
                }
            }
        }
    }
}