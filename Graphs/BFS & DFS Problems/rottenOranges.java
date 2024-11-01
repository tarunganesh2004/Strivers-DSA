import java.util.*;

class pair {
    int row;
    int col;
    int time;

    pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
public class rottenOranges {
    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }; // o/p: 4
        int r = orangesRotting(grid);
        System.out.println(r);
    }

    static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<pair> q = new LinkedList<>();

        int[][] vis = new int[n][m];
        int cntFresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }

        int time = 0;
        int cnt = 0;
        int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        while (!q.isEmpty()) {
            pair cur= q.poll();
            int r = cur.row;
            int c = cur.col;
            int t = cur.time;
            time = Math.max(time, t);
            for (int[] d : dir) {
                int nR = r + d[0];
                int nC = c + d[1];
                if (nR >= 0 && nR < n && nC >= 0 && nC < m && vis[nR][nC] == 0 && grid[nR][nC] == 1) {
                    q.add(new pair(nR, nC, t + 1));
                    vis[nR][nC] = 2;
                    cnt++;
                }
            }

        }
        if (cnt != cntFresh) {
            return -1;
        }
        return time;
    }
}