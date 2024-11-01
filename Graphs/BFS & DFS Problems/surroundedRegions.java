public class surroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' }
        };

        fill(board);
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    static void dfs(int row, int col, char[][] mat, int[][] vis) {
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;
        
        for (int[] d : dir) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && vis[newRow][newCol] == 0 && mat[newRow][newCol] == 'O') {
                dfs(newRow, newCol, mat, vis);
            }
        }
    }

    static char[][] fill(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];

        // traverse first  and last row
        for (int j = 0; j < m; j++) {
            // first row
            if (vis[0][j] == 0 && mat[0][j] == 'O') {
                dfs(0, j, mat, vis);
            }

            // last row
            if (vis[n - 1][j] == 0 && mat[n - 1][j] == 'O') {
                dfs(n - 1, j, mat, vis);
            }
        }

        for (int i = 0; i < n; i++) {
            // first column
            if (vis[i][0] == 0 && mat[i][0] == 'O') {
                dfs(i, 0, mat, vis);
            }

            // last column
            if (vis[i][m - 1] == 0 && mat[i][m - 1] == 'O') {
                dfs(i, m - 1, mat, vis);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 'O' && vis[i][j] == 0) {
                    mat[i][j] = 'X';
                }
            }
        }
        return mat;
    }
}
