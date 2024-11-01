public class countNoofSetBits {
    public static void main(String[] args) {
        int n = 13;
        int c = 0;
        while (n > 1) {
            c += n & 1;
            n = n / 2;
        }
        if (n == 1)
            c += 1;
        System.out.println(c);
    }
}
