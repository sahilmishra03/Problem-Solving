public class Video40 {
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

    public static void singleChildNode(Node root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right != null) {
            System.out.println(root.right.data);
        }

        if (root.left != null && root.right == null) {
            System.out.println(root.left.data);
        }

        singleChildNode(root.left);
        singleChildNode(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(25);
        root.right = new Node(75);
        root.left.left = new Node(12);
        root.left.right = new Node(37);
        root.right.left = new Node(62);
        root.left.right.left = new Node(30);
        root.right.left.right = new Node(60);

        singleChildNode(root);
    }
}
