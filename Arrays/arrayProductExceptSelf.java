import java.util.Arrays;

public class arrayProductExceptSelf {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(product(a)));
    }

    public static int[] product(int[] a) {
        int n = a.length;
        int[] p = new int[n];
        p[0] = 1;
        for (int i = 1; i < n; i++) {
            p[i] = p[i - 1] * a[i - 1];
        }
        int[] s = new int[n];
        s[n - 1] = 1;
        for(int i=n-2;i>=0;i--){
            s[i] = s[i + 1] * a[i + 1];
        }
        int r[] = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = p[i] * s[i];
        }
        return r;
    }
}
