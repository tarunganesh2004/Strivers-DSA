
// import java.util.Arrays;
import java.util.Scanner;

class Main {

    // One Method
    // public static void main(String[] args) {
    // // Write your code here
    // Scanner sc = new Scanner(System.in);
    // int n = sc.nextInt();
    // int[] arr = convertToDigits(n);
    // // System.out.println(Arrays.toString(arr));

    // int even = 0;
    // int odd = 0;
    // for (int i = 0; i < arr.length; i++) {
    // if (arr[i] % 2 == 0) {
    // even += arr[i];
    // } else {
    // odd += arr[i];
    // }
    // }
    // System.out.println(even + " " + odd);

    // }

    // private static int[] convertToDigits(int number) {
    // String numStr = String.valueOf(number);
    // int[] digits = new int[numStr.length()];

    // for (int i = 0; i < numStr.length(); i++) {
    // digits[i] = Character.getNumericValue(numStr.charAt(i));
    // }

    // return digits;
    // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = String.valueOf(n);
        int len = s.length();
        int rem;
        int even = 0;
        int odd = 0;
        int start = 0;
        while (start < len) {
            rem = n % 10;
            int a = n / 10;
            n = a;
            if (rem % 2 == 0) {
                even += rem;
            } else {
                odd += rem;
            }
            start++;
        }
        System.out.println(even + " " + odd);
        sc.close();
    }
}
