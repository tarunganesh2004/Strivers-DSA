public class decToBin {
    public static void main(String[] args) {
        int n = 5;
        String res = "";
        while (n != 1) {
            if (n % 2 == 1) {
                res += '1';
            } else {
                res += '0';
            }
            n = n / 2;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : res.toCharArray()) {
            sb.append(c);
        }
        // return sb.reverse().toString();
        System.out.println(Integer.toBinaryString(n));
        System.out.println(sb.reverse().toString());
    }
}
