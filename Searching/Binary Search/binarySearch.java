public class binarySearch {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6 };
        int target = 2;
        int low = 0;
        int high  = a.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if (a[mid] == target) {
                System.out.println(mid);
                break;
            } else if (a[mid] < target) {
                
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }
}
