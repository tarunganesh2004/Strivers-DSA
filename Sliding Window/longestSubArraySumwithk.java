public class longestSubArraySumwithk {
    public static void main(String[] args) {
        int[] a = { 2, 3,5,1,9 };
        int k = 10;
        System.out.println(longest(a, k));
    }

    public static int longest(int[] a, int k) {
        // only positive numbers
        int n = a.length;
        int sum = 0;
        int maxLen = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {
            sum += a[r];

            // Shrink the window until the sum is less than or equal to k
            while (sum > k) {
                sum -= a[l];
                l++;
            }

            // Update the maximum length of the subarray with sum <= k
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
