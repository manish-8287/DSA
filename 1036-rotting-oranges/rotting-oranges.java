import java.util.*;

class Solution {
    class Pair {
        int i;
        int j;
        int steps;

        public Pair(int x, int y, int steps) {
            this.i = x;
            this.j = y;
            this.steps = steps;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dirx = {-1, 0, 1, 0};
        int[] diry = {0, 1, 0, -1};
        Queue<Pair> q = new LinkedList<>();
        boolean[][] isVis = new boolean[n][m];

        // Push all initially rotten oranges into the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    isVis[i][j] = true;
                }
            }
        }

        int steps = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.i;
            int j = p.j;
            steps = p.steps;

            for (int d = 0; d < 4; d++) {
                int ni = i + dirx[d];
                int nj = j + diry[d];

                if (ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == 1 && !isVis[ni][nj]) {
                    q.add(new Pair(ni, nj, steps + 1));
                    grid[ni][nj] = 2;  
                    isVis[ni][nj] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return steps;
    }
}
