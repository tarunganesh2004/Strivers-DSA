import java.util.*;

public class removeDuplicates {
    public static void main(String[] args) {
        int[] a = { 1, 1, 2, 2, 2, 3, 3 };
        System.out.println(unique(a));
    }

    public static int unique(int[] a) {
        int n = a.length;
        // Map<Integer,Integer> hm = new HashMap<>();
        Set<Integer> s = new HashSet<>();
        for (int i : a) {
            if (s.contains(i)) {
                continue;
            }
            s.add(i);
        }
        return s.size();
    }
}
