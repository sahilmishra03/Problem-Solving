public class Video32_38 {
    public static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node('a');
        root.left = new Node('b');
        root.right = new Node('c');
        root.left.left = new Node('d');
        root.left.right = new Node('e');
        root.right.left = new Node('f');
        root.right.right = new Node('g');

        inOrder(root);

        leftClonedTreeHelper(root);

        System.out.println();

        inOrder(root);

        leftClonedTreeBackHelper(root);

        System.out.println();

        inOrder(root);
    }

    public static Node leftClonedTreeBackHelper(Node root) {
        if (root == null) {
            return null;
        }

        Node lnr = leftClonedTreeBackHelper(root.left.left);
        Node rnr = leftClonedTreeBackHelper(root.right);

        root.left = lnr;
        root.right = rnr;

        return root;
    }

    public static Node leftClonedTreeHelper(Node root) {
        if (root == null) {
            return null;
        }

        Node lnr = leftClonedTreeHelper(root.left);
        Node rnr = leftClonedTreeHelper(root.right);

        Node nn = new Node(root.data);
        nn.left = lnr;
        root.left = nn;
        root.right = rnr;

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