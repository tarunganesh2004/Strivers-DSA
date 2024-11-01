public class countGoodNumbers {
    private static int mod=1000000007;
    public static void main(String[] args) {
        int n = 1;
        System.out.println(countGood(n));
    }

    public static int countGood(int n) {
        if (n == 1) {
            return 5;
        }
        int c = 0;
        for (int i = (int) Math.pow(10, n - 1); i < (int) (Math.pow(10, n)); i++) {
            if (isGood(i, n)) {
                c = (c + 1) % mod;
            }
        }
        return c;

    }
    
    public static boolean isGood(int n, int length) {
        String s = Integer.toString(n);
        for (int i = 0; i < length; i++) {
            int d = s.charAt(i) - '0';
            if (i % 2 == 0) { // even position
                if (d % 2 != 0) {
                    return false;
                }
            } else {
                if (!(d == 2 || d == 3 || d == 5 || d == 7)) {
                    return false;
                }
            }
        }
        return true;
    }
}
