public class Video42 {
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

    public static void removeLeafNode(Node root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                root.left = null;
            }
        }

        if (root.right != null) {
            if (root.right.left == null && root.right.right == null) {
                root.right = null;
            }
        }

        removeLeafNode(root.left);
        removeLeafNode(root.right);
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
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
        root.right.left.right = new Node(10);

        preOrder(root);
        removeLeafNode(root);
        System.out.println();
        preOrder(root);
    }
}
