public class climbingStairs {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(ways(n));
    }

    // Tabulation approach(doesn't work for large test cases)
    public static int ways(int n) {
        if (n <= 2)
            return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
