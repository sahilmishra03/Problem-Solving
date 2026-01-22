package BT;

public class Video04 {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int size = 0;

    public static void size(Node root) {
        // Method to calculate size of the tree
        if (root == null) {
            return;
        }

        size(root.left);
        size++;
        size(root.right);
    }

    public static int size2(Node root) {
        // Method to calculate size of the tree
        if (root == null) {
            return 0;
        }

        return size2(root.left) + 1 + size2(root.right);
    }

    public static int sum = 0;

    public static void sum(Node root) {
        // Method to calculate size of the tree
        if (root == null) {
            return;
        }

        sum(root.left);
        sum += root.data;
        sum(root.right);
    }

    public static int sum2(Node root) {
        // Method to calculate sum of the tree
        if (root == null) {
            return 0;
        }

        return sum2(root.left) + root.data + sum2(root.right);
    }

    public static int max(Node root) {
        // Method to calculate max value in the tree
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        return Math.max(root.data, Math.max(max(root.left), max(root.right)));
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(25);
        root.right = new Node(75);
        root.left.left = new Node(72);
        root.left.right = new Node(37);
        root.right.left = new Node(62);
        root.right.right = new Node(87);
        root.left.right.left = new Node(30);
        root.right.left.right = new Node(70);

        size(root);

        System.out.println("Size of the tree: " + size);

        sum(root);

        System.out.println("Sum of all nodes: " + sum);
    }
}
