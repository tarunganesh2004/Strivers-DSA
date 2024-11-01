
public class bitwise {
    public static void main(String[] args) {
        int n = 13;
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        // right shift --> >> (x/2^k)
        System.out.println(13 >> 2);
        
        // left shift ----> (<< ) (x*2^k)
        System.out.println(13 << 2);
        
        // when ever to find binary of negative number do 2's compliment 
    }
}
