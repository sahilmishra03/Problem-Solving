import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RV02 {
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
        newTree.left.left = new Node(12);
        newTree.left.right = new Node(37);
        newTree.right.left = new Node(62);
        newTree.right.right = new Node(87);
        newTree.left.right.left = new Node(30);
        newTree.left.right.right = new Node(40);
        newTree.right.left.left = new Node(60);
        newTree.right.left.right = new Node(70);

        int target = 37;
        int k = 2;
        kdistance(newTree, target, k);
    }

    public static void printKLevelsDown(Node root, int k, Node blocker) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (level == k) {
                    System.out.println(curr.val);
                }
                if (curr.left != null && curr.left != blocker) {
                    queue.add(curr.left);
                }
                if (curr.right != null && curr.right != blocker) {
                    queue.add(curr.right);
                }
            }

            if (level == k)
                break;
            level++;
        }
    }

    static ArrayList<Node> path;

    public static boolean nodeToRootPath(Node root, int target) {
        if (root == null)
            return false;

        if (root.val == target) {
            path.addFirst(root);
            return true;
        }

        boolean ls = nodeToRootPath(root.left, target);
        if (ls) {
            path.add(root);
            return true;
        }
        boolean rs = nodeToRootPath(root.right, target);
        if (rs) {
            path.add(root);
            return true;
        }

        return false;
    }

    public static void kdistance(Node root, int target, int k) {
        path = new ArrayList<>();
        nodeToRootPath(root, target);

        for (int i = 0; i < path.size(); i++) {
            Node blocker = (i == 0) ? null : path.get(i - 1);
            printKLevelsDown(path.get(i), k - i, blocker);
        }
    }
}
