import java.util.*;
class printSubsequences {
    public static void main(String[] args) {
        int[] a = { 3, 1, 2 }; // subsequences are
        // 3
        // 1
        // 2
        // 3 1
        // 1 2
        // 3 2 , apart from this all are subarrays, so total subsequences are 2^n
        // 3,1,2

        print(a, 0, new ArrayList<>());
        String s = "abc";
        print(s, 0, "");
    }

    static void print(int[] a, int ind, List<Integer> list) {
        if (ind == a.length) {
            for (int k : list) {
                System.out.print(k + " ");
            }
            System.out.println();
            return;
        }
        // take the current element
        list.add(a[ind]);
        print(a, ind + 1, list);
        list.remove(list.size() - 1);
        // don't take the current element
        print(a, ind + 1, list);
    }
    
    // print subsequences of a string
    static void print(String s, int ind, String cur) {
        if (ind == s.length()) {
            System.out.println(cur);
            return;
        }
        // including the current character
        print(s, ind + 1, cur + s.charAt(ind));

        // not including the current character
        print(s, ind + 1, cur);
    }
}