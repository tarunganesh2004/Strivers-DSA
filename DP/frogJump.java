public class frogJump {
    public static void main(String[] args) {
        int[] h = { 10, 30, 40, 20 };
        System.out.println(f(h));
        System.out.println(fSpaceOptimized(h));
    }

    static int f(int i, int[] h) {
        if (i == 0)
            return 0;

        int left = f(i - 1, h) + Math.abs(h[i] - h[i - 1]);
        int right = Integer.MAX_VALUE;
        if (i > 1) {
            right = f(i-2, h) + Math.abs(h[i] - h[i - 2]);
        }
        return Math.min(left, right);
    }

    // memoization
    static int f(int i, int[] h, int[] dp) {
        if (i == 0)
            return 0;
        if (dp[i] != -1)
            return dp[i];

        int left = f(i - 1, h, dp) + Math.abs(h[i] - h[i - 1]);
        int right = Integer.MAX_VALUE;
        if (i > 1) {
            right = f(i - 2, h, dp) + Math.abs(h[i] - h[i - 2]);
        }
        return dp[i] = Math.min(left, right);
    }

    // now memoization(top-down) to tabulation(bottom-up)
    static int f(int[] h) {
        int n = h.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int left = dp[i - 1] + Math.abs(h[i] - h[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = dp[i - 2] + Math.abs(h[i] - h[i - 2]);
            }
            dp[i] = Math.min(left, right);
        }
        return dp[n - 1];
    }

    // now we can optimize the space complexity
    static int fSpaceOptimized(int[] h) {
        int n = h.length;
        int prev = 0;
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int left = prev + Math.abs(h[i] - h[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = prev2 + Math.abs(h[i] - h[i - 2]);
            }
            int curr = Math.min(left, right);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
