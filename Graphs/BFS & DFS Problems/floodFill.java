import java.util.*;

public class floodFill {
    static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static void main(String[] args) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1, sc = 1, newColor = 2;
        int[][] r = floodfill(image, sr, sc, newColor);
        System.out.println(Arrays.deepToString(r));
    }

    public static void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int iniColor) {
        ans[row][col] = newColor;

        int n = image.length;
        int m = image[0].length;
        for (int[] d : dir) {
            int newR = row + d[0];
            int newC = col + d[1];
            if (newR >= 0 && newR < n && newC >= 0 && newC < m && image[newR][newC] == iniColor
                    && ans[newR][newC] != newColor) {
                dfs(newR, newC, ans, image, newColor, iniColor);
            }
        }
    }

    public static int[][] floodfill(int[][] image, int sr, int sc, int newColor) {
        // create a copy of image
        int iniColor = image[sr][sc];
        int[][] ans = image;
        
        dfs(sr,sc, ans,image, newColor, iniColor);
        return ans;
    }

    
}
