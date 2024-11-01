public class bitSetOrNot {
    public static void main(String[] args) {
        // check if the ith bit is set or not

        int n = 13;
        int i = 2;

        //  using leftshift
        if ((n & (1 << i)) != 0) {
            // 1<<i --> 1<<2 --> 100
            //  1 1 0 1
            //&   1 0 0
            //==> 1
        
            System.out.println("set");
        } else {
            System.out.println("not set");
        }

        // using rightShift
        if (((n >> i) & 1) == 0) {
            System.out.println("not set");
        } else {
            System.out.println("set");
        }
    }
}
