import java.util.*;
class fibonacciNumber{
    public static void main(String[] args) {
        int n = 5; // 0 1 1 2 3 5
        System.out.println(f(n));
        System.out.println(f1(n));
        System.out.println(f2(n));
        System.out.println(optimized(n));
    }

    // recursive solution
    public static int f(int n) {
        if (n <= 1)
            return n;
        return f(n - 1) + f(n - 2);
    }

    // memoization 
    public static int f1(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        if (n <= 1)
            return n;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = f1(n - 1) + f1(n - 2);
    }

    // tabulation
    public static int f2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // space optimized approach
    public static int optimized(int n) {
        int prev2 = 0;
        int prev = 1;
        for (int i = 2; i <= n; i++) {
            int cur = prev2 + prev;
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}