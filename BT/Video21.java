import java.util.*;

public class Video21 {
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
        root.left.left = new Node(12);
        root.left.right = new Node(37);
        root.right.left = new Node(62);
        root.right.right = new Node(87);
        root.left.right.left = new Node(30);
        root.left.right.right = new Node(40);
        root.right.left.left = new Node(60);
        root.right.left.right = new Node(70);

        int k = 2;
        int currCountOfLevel = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node n = queue.remove();
                list.add(n.data);

                if (n.left != null) {
                    queue.add(n.left);
                }

                if (n.right != null) {
                    queue.add(n.right);
                }
            }

            if (k == currCountOfLevel) {
                System.out.println(list);
                break;
            }

            currCountOfLevel++;
        }

    }
}
