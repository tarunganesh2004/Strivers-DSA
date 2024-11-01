public class repeatingAndMissingNumber {
    // public static int[] findMissingRepeatingNumbers(int []a) {
    //     // Write your code here
    //     int mis=0;
    //     int n=a.length;
    //     int total=n*(n+1)/2;
    //     int sum=0;
    //     for(int i=0;i<n;i++){
    //         sum+=a[i];
    //     }
    //     mis=total-sum;

        
    // }
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 2 };
        int mis = 0;
        int n = a.length;
        int total = n * (n + 1) / 2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        mis = total - sum;
    System.out.println(mis);
    }
}