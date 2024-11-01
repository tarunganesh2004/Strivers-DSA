public class binToDec {
    public static void main(String[] args) {
        String s = "101";
        int n = s.length();
        int num = 0;
        int p2=1; // power of 2
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                num = num + p2;
            }
            p2 = p2 * 2;
        }
        System.out.println(num);
    }
}
