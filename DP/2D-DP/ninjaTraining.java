// package 2D-DP;
//  https://www.naukri.com/code360/problems/ninja-s-training_3621003?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

import java.util.*;
public class ninjaTraining {
    public static void main(String[] args) {
        int[][] a = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };
        int n = a.length;
        int[][] memo = new int[n][4]; 
        for (int[] row : memo) {
            Arrays.fill(row, -1); 
        }
        System.out.println(f(a, n - 1, 3, memo));
    }

    public static int f(int[][] a, int day, int last, int[][] memo) {
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task <= 2; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, a[0][task]);
                }
            }
            return maxi;
        }

        if (memo[day][last] != -1) {
            return memo[day][last];
        }

        int max = 0;
        for (int task = 0; task <= 2; task++) {
            if (task != last) {
                int point = a[day][task] + f(a, day - 1, task, memo);
                max = Math.max(max, point);
            }
        }

        memo[day][last] = max;
        return max;
    }
}
