import java.util.Arrays;

public class frogJumpWithKDistances {
    public static void main(String[] args) {
        int[] h = { 10, 40, 30, 10 };
        int k = 2;
        System.out.println(ftabulation(h, k));

        System.out.println(fr(h.length - 1, h, k));
        int[] dp = new int[h.length];
        Arrays.fill(dp, -1);
        System.out.println(fr(h.length - 1, h, k, dp));
    }

    // recursion approach
    static int fr(int ind, int[] h, int k) {
        if (ind == 0)
            return 0;
        int minSteps = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (ind - j >= 0) {
                int jump = fr(ind - j, h, k) + Math.abs(h[ind] - h[ind - j]);
                minSteps = Math.min(minSteps, jump);
            }
        }
        return minSteps;
    }

    // memoization approach
    static int fr(int ind, int[] h, int k, int[] dp) {
        if (ind == 0)
            return 0;
        if (dp[ind] != -1)
            return dp[ind];
        int minSteps = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (ind - j >= 0) {
                int jump = fr(ind - j, h, k, dp) + Math.abs(h[ind] - h[ind - j]);
                minSteps = Math.min(minSteps, jump);
            }
        }
        return dp[ind] = minSteps;
    }
    // tabulation approach
    public static int ftabulation(int[] h, int k) {
        int n = h.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(h[i] - h[i - j]);
                    minSteps = Math.min(minSteps, jump);
                }

            }
            dp[i] = minSteps;
        }
        return dp[n - 1];
    }

    // space optimized tabulation approach
    public static int fSpaceOptimized(int[] h, int k) {
        int n = h.length;
        int prev = 0;
        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = prev + Math.abs(h[i] - h[i - j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            prev = minSteps;
        }
        return prev;
    }
}
