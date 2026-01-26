import java.util.*;

public class Video25 {
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
        int data = 75;
        nodeToRootPath(root, data);
        int k = 2;

        for (int i = 0; i < path.size(); i++) {
            Node blocker = null;
            if (i > 0) {
                blocker = path.get(i - 1);
            }
            kLevelDownWithBlocker(path.get(i), k - i, blocker);
        }
    }

    public static void kLevelDownWithBlocker(Node root, int k, Node blocker) {
        if (root == null || root == blocker)
            return;
        int currLevel = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node n = queue.remove();
                if (n == blocker) {
                    continue;
                }
                level.add(n.data);
                if (n.left != null && n.left != blocker) {
                    queue.add(n.left);
                }
                if (n.right != null && n.right != blocker) {
                    queue.add(n.right);
                }
            }
            if (currLevel == k) {
                System.out.println(level);
                break;
            }
            currLevel++;
        }
    }

    static ArrayList<Node> path;

    public static boolean nodeToRootPath(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (root.data == data) {
            path.add(root);
            return true;
        }

        boolean left = nodeToRootPath(root.left, data);
        if (left) {
            path.add(root);
            return true;
        }
        boolean right = nodeToRootPath(root.right, data);
        if (right) {
            path.add(root);
            return true;
        }
        return false;
    }
}
