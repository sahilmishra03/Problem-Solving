import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RV01 {
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

    public static int size(Node root) {
        if (root == null) {
            return 0;
        }

        int left = size(root.left);
        int right = size(root.right);

        int ts = left + right + 1;

        return ts;
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }

        int left = sum(root.left);
        int right = sum(root.right);

        int ts = left + right + root.val;

        return ts;
    }

    public static int max(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int left = max(root.left);
        int right = max(root.right);

        int ts = Math.max(Math.max(left, right), root.val);

        return ts;
    }

    public static int min(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int left = min(root.left);
        int right = min(root.right);

        int ts = Math.min(Math.min(left, right), root.val);

        return ts;
    }

    public static int heightEdge(Node root) {
        if (root == null) {
            return -1;
        }

        int left = heightEdge(root.left);
        int right = heightEdge(root.right);

        int ts = Math.max(left, right) + 1;

        return ts;
    }

    public static int heightNode(Node root) {
        if (root == null) {
            return 0;
        }

        int left = heightNode(root.left);
        int right = heightNode(root.right);

        int ts = Math.max(left, right) + 1;

        return ts;
    }

    public static boolean find(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (root.val == data) {
            return true;
        }

        boolean left = find(root.left, data);
        if (left) {
            return true;
        }

        boolean right = find(root.right, data);
        if (right) {
            return true;
        }

        return false;
    }

    static ArrayList<Integer> path;

    public static boolean nodeToRootPath(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (root.val == data) {
            path.add(root.val);
            return true;
        }

        boolean left = nodeToRootPath(root.left, data);
        if (left) {
            path.add(root.val);
            return true;
        }

        boolean right = nodeToRootPath(root.right, data);
        if (right) {
            path.add(root.val);
            return true;
        }

        return false;
    }

    public static void printKLevelsDown(Node root, int k) {
        if (root == null || k < 0) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (level == k) {
                for (int i = 0; i < size; i++) {
                    Node curr = queue.poll();
                    System.out.print(curr.val + " ");
                    queue.add(curr);
                }
                return;
            }
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            level++;
        }

    }

    public static void printNodesAtKDistance(Node root, int data, int k) {
        path = new ArrayList<>();
        nodeToRootPath(root, data);
        for (int i = 0; i < path.size(); i++) {
            printKLevelsDown(root, k - i);
            root = null;
        }
    }

    public static Node removeLeaves(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return null;
        }

        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    static int tilt;

    public static int tiltOfBinaryTree(Node root) {
        // TODO
        if (root == null) {
            return 0;
        }

        int left = tiltOfBinaryTree(root.left);
        int right = tiltOfBinaryTree(root.right);
        tilt += Math.abs(left - right);
        int ts = left + right + root.val;
        return ts;
    }

    public static boolean isBalanced(Node root) {
        // TODO
        if (root == null) {
            return true;
        }
        boolean ls = isBalanced(root.left);
        if (!ls) {
            return false;
        }
        boolean rs = isBalanced(root.right);
        if (!rs) {
            return false;
        }
        int left = heightEdge(root.left);
        int right = heightEdge(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        path = new ArrayList<>();
        tilt = 0;
        Node newTree = new Node(50);
        newTree.left = new Node(25);
        newTree.right = new Node(75);
        newTree.left.left = new Node(12);
        newTree.left.left.left = new Node(37);

        System.out.println(isBalanced(newTree));

    }
}
