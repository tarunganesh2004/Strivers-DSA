public class reverse {
    public static void main(String[] args) {
        int n = 123;
        System.out.println(reversen(n));
    }

    public static int reversen(int n) {
        int res = 0;
        while (n > 0) {
            int r = n % 10;
            res = (res * 10) + r;
            n = n / 10;
        }
        return res;
    }
}
