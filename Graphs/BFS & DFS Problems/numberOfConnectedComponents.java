// LC 200 Number of Islands
import java.util.*;
public class numberOfConnectedComponents {
    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 1, 1, 0, 1 } }; // o/p: 3
        int r = numIslands(grid);
        System.out.println(r);
    }

    public static int numIslands(int[][] grid) {
        // the intution is store the row and columns as a pair and create a same size 2d Array to store the visited nodes
        // then iterate over the grid and if the node is not visited then increment the count and call the dfs function

        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // if the node is not visited and the node is 1 then increment the count and call the dfs function
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    c++;
                    // dfs(i, j, grid, vis);
                    bfs(i,j, grid, vis);
                }
            }
        }
        return c;
    }

    public static void dfs(int row, int col, int[][] grid, int[][] vis) {
        // if the node is visited then return
        if (vis[row][col] == 1) {
            return;
        }
        // mark the node as visited
        vis[row][col] = 1;
        // create a 2d array to store the 4 directions
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        // iterate over the 4 directions
        for (int i = 0; i < 4; i++) {
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];
            // if the new row and new col are within the bounds and the node is not visited and the node is 1 then call the dfs function
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                    && vis[newRow][newCol] == 0
                    && grid[newRow][newCol] == 1) {
                dfs(newRow, newCol, grid, vis);
            }
        }

    }

    public static void bfs(int row, int col, int[][] grid, int[][] vis) {
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { row, col });
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            for (int[] d : dir) {
                int newRow = curRow + d[0];
                int newCol = curCol + d[1];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && vis[newRow][newCol] == 0
                        && grid[newRow][newCol] == 1) {
                    vis[newRow][newCol] = 1;
                    q.add(new int[] { newRow, newCol });
                }
            }
        }
    }

    // find the max area
    public static int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    int area = dfsArea(i, j, grid, vis);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public static int dfsArea(int row, int col, int[][] grid, int[][] vis) {
        if (vis[row][col] == 1) {
            return 0;
        }
        vis[row][col] = 1;
        int area = 1;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for(int[] d: dir) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && vis[newRow][newCol] == 0 && grid[newRow][newCol] == 1) {
                area += dfsArea(newRow, newCol, grid, vis);
            }
        }
        return area;
    }
}
