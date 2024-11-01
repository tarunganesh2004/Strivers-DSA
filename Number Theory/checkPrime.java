class checkPrime{
    public static void main(String[] args) {
        int n = 10;
        // for (int i = 2; i < n; i++) {
        //     if (n % i == 0) {
        //         System.out.println("Not Prime");
        //         return;
        //     } else {
        //         System.out.println("Prime");
        //         return;
        //     }
        // }
System.out.println(countPrimes(n));
    }

    public static int countPrimes(int n) {
        int c = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                c++;
            }
        }
        return c;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}