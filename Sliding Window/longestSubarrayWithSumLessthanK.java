class longestSubArrayWithSumLessThanK {
    public static void main(String[] args) {
        int[] a = { 2, 5, 1, 7, 10 };
        int k = 14;
        System.out.println(longestSubarray(a, k));
        System.out.println(longest(a, k));
        System.out.println(longestOptimal(a, k));
    }

    // Optimal
    public static int longestOptimal(int[] a, int k) {
        int n = a.length;
        int sum = 0;
        int maxLen = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            sum += a[r];
            if (sum > k) {
                sum -= a[l];
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }

    // better TC: O(N+N)
    public static int longestSubarray(int[] a, int k) { // O(N) Time Complexity
        int l = 0;
        int r = 0;
        int sum = 0;
        int maxLength = 0;
        while (r < a.length) {
            sum += a[r];
            while (sum > k) {
                sum = sum - a[l];
                l++;
            }
            if (sum <= k) {
                maxLength = Math.max(maxLength, r - l + 1);
            }
            r = r + 1;
        }
        return maxLength;
    }
    
   
    // bruteforce O(n^2)
    public static int longest(int[] a, int k) {
        int maxlen = 0;
        for (int i = 0; i < a.length; i++) {
            int s = 0;
            for (int j = i; j < a.length; j++) {
                s += a[j];
                if (s <= k) {
                    maxlen = Math.max(maxlen, j - i + 1);
                } else if (s > k)
                    break;
            }
        }
        return maxlen;
    }
}