// House Robber Problem

import java.util.Arrays;

public class maxSumOfNonAdjacentElements {
    public static void main(String[] args) {
        int[] a = { 1, 2, 4 };
        System.out.println(f(a.length - 1, a));
        int[] dp = new int[a.length];
        Arrays.fill(dp, -1);
        System.out.println(f(a, dp, a.length - 1));
        System.out.println(tab(a));
        System.out.println(tabSpaceOptimized(a));

    }

    static int f(int i, int[] a) {
        if (i == 0)
            return a[i];

        if (i < 0)
            return 0;
        int pick = a[i] + f(i - 2, a);// we cannot pickup previous element so we pick i-2 element
        int notpick = 0 + f(i - 1, a);// we can pick previous element so we pick i-1 element
        return Math.max(pick, notpick);
    }
    
    // memoization
    static int f(int[] a, int[] dp, int ind) {
        // int n = a.length;
        if (ind < 0) {
            return 0;
        }
        if (ind == 0) {
            return a[ind];
        }
        if (dp[ind] != -1) {
            return dp[ind];
        }

        int pick = a[ind] + f(a, dp, ind - 2);
        int notpick = 0 + f(a, dp, ind - 1);
        return dp[ind] = Math.max(pick, notpick);
    }
    
    // tabulation
    static int tab(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        dp[0] = a[0];
        // int neg = 0;
        for (int i = 1; i < n; i++) {
            int pick = a[i];
            if (i > 1) {
                pick += dp[i - 2];
            }
            int notpick = 0 + dp[i - 1];
            dp[i] = Math.max(pick, notpick);
        }
        return dp[n - 1];
    }

    // space optimized tabulation
    static int tabSpaceOptimized(int[] a) {
        int n = a.length;
        int prev = a[0];
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int pick = a[i];
            if (i > 1) {
                pick += prev2;
            }
            int notpick = 0 + prev;
            int temp = prev;
            prev = Math.max(pick, notpick);
            prev2 = temp;
        }
        return prev;
    }
}
