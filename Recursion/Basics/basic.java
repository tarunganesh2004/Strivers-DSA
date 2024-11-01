package Basics;

public class basic {
    static int c = 10;
    public static void main(String[] args) {
        call();
    }

    public static void call() {
        if (c == 10)
            return;
        System.out.println(c);
        c++;
        call();
    }
}
