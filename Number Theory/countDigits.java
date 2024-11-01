// import java.util.*;

public class countDigits {
    public static void main(String[] args) {

        int n = 12345;
        System.out.println(count(n));
    }

    public static int count(int n) {
        int c = 0;
        // int t = n;
        // store digits of a number
        // List<Integer> l = new ArrayList<>();
        // while (n > 0) {
        //     int r = n % 10;
        //     l.add(r);
        //     n = n / 10;
        // }
        // Collections.reverse(l);

        while (n > 0) {
            n = n / 10;
            c++;
        }
        return c;

    }
    
    // optimal approach O(1)
    public static int count1(int n) {
        // the count of digits can be calculated by logn to the base 10+1
        int c = (int) (Math.log10(n) + 1);
        return c;
    }
}
