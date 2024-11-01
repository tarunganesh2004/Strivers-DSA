import java.util.*;

public class _01Matrix {
    public static void main(String[] args) {
        int[][] grid = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 1,1,1 }
        };

        int[][] result = updateMatrix(grid);
        for (int[] row : result) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    static int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Distance matrix, initialized to large values
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Queue to perform BFS
        Queue<int[]> q = new LinkedList<>();

        // Start BFS from all the '0' cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    dist[i][j] = 0; // Distance to itself is 0
                    q.add(new int[] { i, j });
                }
            }
        }

        // 4 possible directions to move: right, down, left, up
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // Perform BFS
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];

            // Explore all 4 directions
            for (int[] d : directions) {
                int newRow = row + d[0];
                int newCol = col + d[1];

                // Check if the new position is valid and can be updated
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    // If the current distance is smaller, update it
                    if (dist[newRow][newCol] > dist[row][col] + 1) {
                        dist[newRow][newCol] = dist[row][col] + 1;
                        q.add(new int[] { newRow, newCol });
                    }
                }
            }
        }

        return dist;
    }
}
