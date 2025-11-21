public class RV03 {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node newTree = new Node(50);
        newTree.left = new Node(25);
        newTree.right = new Node(75);
        inOrder(newTree);
        System.out.println("\nCloning left subtree for each node...");
        leftClonedTree(newTree);
        inOrder(newTree);
        System.out.println("\nRollback...");
        leftClonedTree2(newTree);
        inOrder(newTree);
    }

    public static Node leftClonedTree(Node root) {
        if (root == null) {
            return null;
        }

        Node leftClone = leftClonedTree(root.left);
        Node rightClone = leftClonedTree(root.right);
        Node newNode = new Node(root.val);
        newNode.left = leftClone;
        root.left = newNode;
        root.right = rightClone;
        return root;
    }

    public static Node leftClonedTree2(Node root) {
        if (root == null) {
            return null;
        }

        Node ls =leftClonedTree2(root.left.left);
        Node rs =leftClonedTree2(root.right);
        root.left=ls;
        root.right=rs;

        return root;

    }

    public static void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
}