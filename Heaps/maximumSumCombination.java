// https://www.geeksforgeeks.org/problems/maximum-sum-combination/0

import java.util.*;
public class maximumSumCombination {
    public static void main(String[] args) {
        int[] a = { 3, 2 };
        int[] b = { 1, 4 };
        int k = 2; // o/p: {7,6};
        System.out.println(maxSumCombination(a, b, k));
    }

    public static List<Integer> maxSumCombination(int[] a,int[] b,int k){
        int n = a.length;
        Arrays.sort(a);
        Arrays.sort(b);

        // max Heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(y[0], x[0]));
        // set to avoid processing the same pair twice
        Set<String> seen = new HashSet<>();

        pq.add(new int[] { a[n - 1] + b[n - 1], n - 1, n - 1 });
        seen.add((n - 1) + "," + (n - 1));

        List<Integer> r=new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int[] cur = pq.poll();
            int sum = cur[0];
            int i1 = cur[1];
            int i2 = cur[2];
            r.add(sum);

            // push the next pair (i1-1,i2) if it hasn't been seen
            if (i1 - 1 >= 0 && !seen.contains((i1 - 1) + "," + i2)) {
                pq.add(new int[] { a[i1 - 1] + b[i2], i1 - 1, i2 });
                seen.add((i1 - 1) + "," + i2);
            }
            // push the next pair (i1,i2-1) if it hasn't been seen
            if (i2 - 1 >= 0 && !seen.contains(i1 + "," + (i2 - 1))) {
                pq.add(new int[] { a[i1] + b[i2 - 1], i1, i2 - 1 });
                seen.add(i1 + "," + (i2 - 1));
            }
        }
        return r;
    }
}
