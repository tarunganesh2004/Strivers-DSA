// import java.util.*;
import java.lang.Math;

public class Main {
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] arr = { -36,36 };
        recursion(arr, 0, 0, 0);
        System.out.println(minDiff);
    }

    static void recursion(int[] arr, int index, int arr1Sum, int arr2Sum) {
        if (index == arr.length) {
            minDiff = Math.min(minDiff, Math.abs(arr1Sum - arr2Sum));
            return;
        }
        recursion(arr, index + 1, arr1Sum + arr[index], arr2Sum);
        recursion(arr, index + 1, arr1Sum, arr2Sum + arr[index]);
    }
}