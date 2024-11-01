public class upperBound {
    // Upperbound: Smallest Index such that arr[idx]>x
    public static void main(String[] args) {
        int[] a = { 2, 3, 6, 7, 8, 8, 11, 11, 11, 12 }; // o/p: 3
        int x = 6;
        System.out.println(getUpperBound(a, x));
    }

    public static int getUpperBound(int[] a, int x) {
            int left = 0;
            int right = a.length - 1;
            int ans = a.length;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (a[mid] > x) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
    }
}
