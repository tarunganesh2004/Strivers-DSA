// maximum length of sub array with size k
public class subarraywithSumk {
    public static void main(String[] args) {
        int[] a = { -1, 2, 3, 3, 4, 5, -1 };
        int k = 4;
        System.out.println(maxSum(a, k));
    }

    static int maxSum(int[] a, int k) {
        int n = a.length;
        if (n < k)
            return -1;
        int curSum = 0;
        for (int i = 0; i < k; i++) {
            curSum += a[i];
        }

        int maxSum = curSum;
        for (int i = k; i < n; i++) {
            curSum = curSum - a[i - k] + a[i];
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
