package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        adj.add(new ArrayList<>(Arrays.asList(0, 1, 0)));
        adj.add(new ArrayList<>(Arrays.asList(1, 0, 1)));

        int res = numProvinces(adj, adj.size());

        System.out.println(res);
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int n) {
        // code here
        int count = 0;
        boolean[] visisted = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visisted[i]) {
                bfs(i, visisted, adj);
                count++;
            }
        }

        return count;
    }

    static void bfs(int i, boolean[] visisted, ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visisted[i] = true;

        while (!q.isEmpty()) {
            int front = q.remove();
            for (int j = 0; j < n; j++) {
                if (adj.get(front).get(j)==1 && visisted[j]==false) {
                    q.add(j);
                    visisted[j]=true;
                }
            }
        }
    }
}
