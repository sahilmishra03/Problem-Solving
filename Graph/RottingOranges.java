package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static class Triplet {
        int row;
        int col;
        int time;

        Triplet(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };

        int res = orangesRotting(grid);

        System.out.println(res);
    }

    public static int orangesRotting(int[][] grid) {
        int maxTime = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<Triplet> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Triplet(i, j, 0));
                }
            }
        }

        while (!q.isEmpty()) {
            Triplet front = q.remove();
            int row = front.row;
            int col = front.col;
            int time = front.time;

            maxTime = Math.max(maxTime, time);

            // UP
            if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                grid[row - 1][col] = 2;
                q.add(new Triplet(row - 1, col, time + 1));
            }

            // DOWN
            if (row + 1 < n && grid[row + 1][col] == 1) {
                grid[row + 1][col] = 2;
                q.add(new Triplet(row + 1, col, time + 1));
            }

            // LEFT
            if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                grid[row][col - 1] = 2;
                q.add(new Triplet(row, col - 1, time + 1));
            }

            // RIGHT
            if (col + 1 < m && grid[row][col + 1] == 1) {
                grid[row][col + 1] = 2;
                q.add(new Triplet(row, col + 1, time + 1));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return maxTime;
    }
}
