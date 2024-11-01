import java.util.*;

class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        int result = numEnclaves(grid);
        System.out.println(result);  // Output should be 0
    }

    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static int numEnclaves(int[][] grid) {
        // Check for empty grid
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        // Add boundary 1's to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // First row, first column, last row, last column
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        q.add(new int[]{i,j});
                        vis[i][j] = 1;
                    }
                }
            }
        }

        // BFS to mark all reachable 1's from the boundaries
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];

            for (int[] d : directions) {
                int r1 = r + d[0];
                int c1 = c + d[1];

                if (r1 >= 0 && r1 < n && c1 >= 0 && c1 < m && vis[r1][c1] == 0 && grid[r1][c1] == 1) {
                    vis[r1][c1] = 1;
                    q.add(new int[]{r1,c1});
                }
            }
        }

        // Count enclaves (1's that are not visited)
        int enclaveCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    enclaveCount++;
                }
            }
        }
        return enclaveCount;
    }
}
