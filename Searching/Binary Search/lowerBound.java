public class lowerBound {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 3, 5, 8, 8, 10, 10, 11 }; //x=8 , O/P: 5
        int[] a1 = { 3, 5, 8, 15, 19 };
        int x = 13;
        int lb = printlb(a1, x);
        System.out.println(lb);
    }

    static int printlb(int[] a, int x) {
        int n = a.length;
        int ans = a.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
