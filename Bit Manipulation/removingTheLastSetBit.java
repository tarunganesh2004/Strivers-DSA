public class removingTheLastSetBit {
    public static void main(String[] args) {
        // removing the rightmost bit
        int n = 12; // 1 1 0 0 --> we need to remove 1 and ans becomes 1 0 0 0

        System.out.println(n &(n-1));
    }
}
