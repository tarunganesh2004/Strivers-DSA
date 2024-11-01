public class setTheithBit {
    public static void main(String[] args) {
        int n = 9; // 1 0 0 1
        int i = 2; // o/p --> 1101-->13
        System.out.println(n | (1 << i));

        int n1 = 13;
        System.out.println(clear(n1, i));
        System.out.println(toggle(n1, i));
    }
    
    // clearing the ith bit
    public static int clear(int n, int i) {
        return n & (~(1 << i));
    }
    
    // toggle the ith bit
    public static int toggle(int n, int i) {
        return (n ^ (1 << i));
    }
}
