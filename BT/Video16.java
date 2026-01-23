import java.util.ArrayList;

public class Video16 {
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

    static ArrayList<Integer> path;

    public static boolean nodeToRootPath(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (root.data == data) {
            path.add(root.data);
            return true;
        }

        boolean left = nodeToRootPath(root.left, data);
        if (left) {
            path.add(root.data);
            return true;
        }
        boolean right = nodeToRootPath(root.right, data);
        if (right) {
            path.add(root.data);
            return true;
        }
        return false;
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

        path = new ArrayList<>();

        nodeToRootPath(root, 70);

        System.out.println(path);
    }
}