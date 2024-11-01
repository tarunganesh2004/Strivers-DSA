// import java.util.*;
public class houseRobberII {
    public static void main(String[] args) {
        int[] a = { 1,2,3 }; // in this case, the robber can't rob both the first and the last house
        System.out.println(houseRobber2(a));
    }

    public static int houseRobber2(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int[] l1 = new int[n - 1];
        int[] l2 = new int[n - 1];

        int a1 = 0, b1 = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                l1[a1] = nums[i];
                a1++;
            }
            if (i != n - 1) {
                l2[b1] = nums[i];
                b1++;
            }
        }
        return Math.max(solve(l1), solve(l2));
    }

    public static int solve(int[] a) {
        int n = a.length;
        int prev = a[0];
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int p = a[i];
            if (i > 1) {
                p += prev2;
            }
            int np = prev;
            int cur = Math.max(p, np);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}
