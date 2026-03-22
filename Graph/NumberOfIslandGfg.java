package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandGfg {
    public static void main(String[] args) {
        char[][] grid = {
                { 'L', 'L', 'W', 'W', 'W' },
                { 'W', 'L', 'W', 'W', 'L' },
                { 'L', 'W', 'W', 'L', 'L' },
                { 'W', 'W', 'W', 'W', 'W' },
                { 'L', 'W', 'L', 'L', 'W' }
        };

        int res = countIslands(grid);

        System.out.println(res);
    }

    public static int countIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean[][] visisted = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visisted[i][j] && grid[i][j] == 'L') {
                    bfs(i, j, visisted, grid);
                    count++;
                }
            }
        }

        return count;
    }

    public static void bfs(int i, int j, boolean[][] visisted, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {
                i, j
        });

        visisted[i][j] = true;

        while (!q.isEmpty()) {
            int[] front = q.remove();

            // Up
            if (front[0] - 1 >= 0) {
                if (!visisted[front[0] - 1][front[1]] && grid[front[0] - 1][front[1]] == 'L') {
                    q.add(new int[] {
                            front[0] - 1,
                            front[1]
                    });

                    visisted[front[0] - 1][front[1]] = true;
                }
            }

            // Down
            if (front[0] + 1 < n) {
                if (!visisted[front[0] + 1][front[1]] && grid[front[0] + 1][front[1]] == 'L') {
                    q.add(new int[] {
                            front[0] + 1,
                            front[1]
                    });

                    visisted[front[0] + 1][front[1]] = true;
                }
            }

            // Left
            if (front[1] - 1 >= 0) {
                if (!visisted[front[0]][front[1] - 1] && grid[front[0]][front[1] - 1] == 'L') {
                    q.add(new int[] {
                            front[0],
                            front[1] - 1
                    });

                    visisted[front[0]][front[1] - 1] = true;
                }
            }

            // Right
            if (front[1] + 1 < m) {
                if (!visisted[front[0]][front[1] + 1] && grid[front[0]][front[1] + 1] == 'L') {
                    q.add(new int[] {
                            front[0],
                            front[1] + 1
                    });

                    visisted[front[0]][front[1] + 1] = true;
                }
            }

            // Up-Left-Digonal
            if (front[0] - 1 >= 0 && front[1] - 1 >= 0) {
                if (!visisted[front[0] - 1][front[1] - 1] && grid[front[0] - 1][front[1] - 1] == 'L') {
                    q.add(new int[] {
                            front[0] - 1,
                            front[1] - 1
                    });

                    visisted[front[0] - 1][front[1] - 1] = true;
                }
            }

            // Up-Right-Digonal
            if (front[0] - 1 >= 0 && front[1] + 1 < m) {
                if (!visisted[front[0] - 1][front[1] + 1] && grid[front[0] - 1][front[1] + 1] == 'L') {
                    q.add(new int[] {
                            front[0] - 1,
                            front[1] + 1
                    });

                    visisted[front[0] - 1][front[1] + 1] = true;
                }
            }

            // Down-Left-Digonal
            if (front[0] + 1 < n && front[1] - 1 >= 0) {
                if (!visisted[front[0] + 1][front[1] - 1] && grid[front[0] + 1][front[1] - 1] == 'L') {
                    q.add(new int[] {
                            front[0] + 1,
                            front[1] - 1
                    });

                    visisted[front[0] + 1][front[1] - 1] = true;
                }
            }

            // Down-Right-Digonal
            if (front[0] + 1 < n && front[1] + 1 < m) {
                if (!visisted[front[0] + 1][front[1] + 1] && grid[front[0] + 1][front[1] + 1] == 'L') {
                    q.add(new int[] {
                            front[0] + 1,
                            front[1] + 1
                    });

                    visisted[front[0] + 1][front[1] + 1] = true;
                }
            }
        }
    }
}
