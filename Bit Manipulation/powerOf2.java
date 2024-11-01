class power{
    public static void main(String[] args) {
        int n=32;
        System.out.println(isPower(n));
    }

    public static boolean isPower(int n) {
        int k = n & (n - 1);
        if (k == 0)
            return true;
        else
            return false;
    }
}