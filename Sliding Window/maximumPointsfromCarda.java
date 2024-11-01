// LC https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
public class maximumPointsfromCarda {
    public static void main(String[] args) {
        int[] a = { 6, 2, 3, 4, 7, 3, 1, 7, 1 };
        int k = 4;
        System.out.println(maxPoints(a, k));

    }

    // TC O(k)
    public static int maxPoints(int[] a, int k) {
        int n = a.length;
        int lsum = 0;
        int rsum = 0;
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            lsum += a[i];
        }
        maxSum = lsum;
        int rightIndex = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            lsum = lsum - a[i];
            rsum = rsum + a[rightIndex];
            // System.out.println(lsum+" "+rsum);
            rightIndex = rightIndex - 1;

            maxSum = Math.max(maxSum, lsum + rsum);
        }
        return maxSum;
    }
}
