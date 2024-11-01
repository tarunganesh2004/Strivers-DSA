public class floorAndCeil {
    // floor : largest no in array<=x
    // ceil : smallest no in array>=x (Lower bound)
    public static void main(String[] args) {
        int[] a = { 10,12,18, 20, 30, 40, 50 };
        int target = 19;
        System.out.print(floor(a, target));
    }

    public static int floor(int[] a, int target) {
        int ans = -1;
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] <= target) {
                ans = a[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int ceil(int[] a, int x) {
        int ans = -1;
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] >= x) {
                ans = a[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }
}
