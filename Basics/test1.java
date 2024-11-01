import java.util.Scanner;

class Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of n for Fibonacci series: ");
        int n = sc.nextInt();

        System.out.println("Fibonacci series up to " + n + " terms:");
        for (int i = 0; i < n; i++) {
            System.out.print(iterativeFibonacci(i) + " ");
        }
        sc.close();
    }

    // Iterative method to calculate Fibonacci numbers
    private static int iterativeFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int fib = 0;
        int prev = 1;
        int temp;

        for (int i = 2; i <= n; i++) {
            temp = fib;
            fib = fib + prev;
            prev = temp;
        }

        return fib;
    }
}
