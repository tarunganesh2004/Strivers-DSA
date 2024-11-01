import java.util.*;
public class numberOfDistinctIslands {
    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } }; // o/p: 1
        int r = numDistinctIslands(grid);
        System.out.println(r);
    }

    public static int numDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<ArrayList<String>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    ArrayList<String> path = new ArrayList<>();
                    dfs(i, j, grid, vis, path, i, j);
                    st.add(path);
                }
            }
        }
        return st.size();
    }

    private static String toString(int row, int col) {
        return Integer.toString(row)+" "+Integer.toString(col);
    }
    private static void dfs(int row, int col, int[][] grid, int[][] vis, ArrayList<String> path, int row0, int col0) {
        vis[row][col] = 1;
        path.add(toString(row - row0, col - col0));
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int i = 0; i < 4; i++) {
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && vis[newRow][newCol] == 0
                    && grid[newRow][newCol] == 1) {
                dfs(newRow, newCol, grid, vis, path, row0, col0);
            }
        }
    }
}
