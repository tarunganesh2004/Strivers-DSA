import java.util.Arrays;

class firstAndLastOccurance {
    public static void main(String[] args) {
        int[] a = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int[] r = find(a,target);
        System.out.println(Arrays.toString(r));
    }

    public static int[] find(int[] a,int target) {
        int first = -1;
        int last = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        return new int[] { first, last };
    }
}