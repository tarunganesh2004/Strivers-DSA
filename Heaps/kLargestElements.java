// https://www.geeksforgeeks.org/problems/k-largest-elements4206/1
import java.util.*;
public class kLargestElements {
    public static void main(String[] args) {
        int[] a = { 12, 5, 787, 1, 23 };
        int k = 2; // o/p: {787,23};
        System.out.println(Arrays.toString(kLargest(a, k)));
    }

    public static int[] kLargest(int[] a, int k) {
        // min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int n : a) {
            if (pq.size() < k) {
                pq.add(n);
            } else if (pq.peek() < n) {
                pq.poll();
                pq.add(n);
            }
        }
        int[] r = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            r[i] = pq.poll();
        }
        return r;
    }
}
