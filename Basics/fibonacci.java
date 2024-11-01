import java.util.Scanner;

class fibonaci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // for (int i = 0; i < n; i++) {
        // System.out.print(fibonacciNumber(i) + " ");
        // }
        int f1 = 1;
        int f2 = 1;
        int fn = 0;
        if (n == 1 | n == 2) {
            fn = 1;
        } else {
            for (int i = 3; i < n; i++) {
                fn = f1 + f2;
                f1 = f2;
                f2 = fn;
            }
        }
        System.out.println(fn);
        sc.close();
    }

    // By using recursion
    public static int fibonacciNumber(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacciNumber(n - 1) + fibonacciNumber(n - 2);
        }
    }
}
