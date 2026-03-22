package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        list.add(Arrays.asList(1));
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3));
        list.add(new ArrayList<>()); // empty list

        boolean res = canVisitAllRooms(list);

       System.out.println(res);
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int front = q.remove();

            for (int i = 0; i < rooms.get(front).size(); i++) {
                int value = rooms.get(front).get(i);
                if (visited[value] == false) {
                    q.add(value);
                    visited[value] = true;
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                return false;
            }
        }

        return true;
    }
}
