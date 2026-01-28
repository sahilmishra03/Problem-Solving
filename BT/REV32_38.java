public class REV32_38 {
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

    public static void main(String[] args) {
        // Left Cloned Tree Question
        Node root = new Node(10);
        root.left = new Node(25);
        root.right = new Node(75);

        inOrder(root);
        leftClonedTreeHelper(root);
        System.out.println();
        inOrder(root);
        leftClonedTreeBackHelper(root);
        System.out.println();
        inOrder(root);
    }

    public static Node leftClonedTreeHelper(Node root) {
        if (root == null) {
            return null;
        }

        Node leftSubTree = leftClonedTreeHelper(root.left);
        Node rightSubTree = leftClonedTreeHelper(root.right);

        Node newNode = new Node(root.data);
        newNode.left = leftSubTree;
        root.left = newNode;
        root.right = rightSubTree;

        return root;
    }

    public static Node leftClonedTreeBackHelper(Node root) {
        if (root == null) {
            return null;
        }

        Node leftSubTree = leftClonedTreeBackHelper(root.left.left);
        Node rightSubTree = leftClonedTreeBackHelper(root.right);

        root.left = leftSubTree;
        root.right = rightSubTree;
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

}
