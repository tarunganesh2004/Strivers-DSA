// create a trie and insert the binary representation of the numbers in the trie. Then, for each number, find the maximum XOR by traversing the trie. The time complexity is O(n * m) where n is the number of elements in the array and m is the number of bits in the maximum number.
class Node {
    Node links[] = new Node[2];

    public Node() {

    }

    public boolean containsKey(int idx) {
        return links[idx] != null;
    }

    public Node get(int idx) {
        return links[idx];
    }

    public void put(int idx, Node node) {
        links[idx] = node;
    }
}

class Trie {
    private static Node root;

    Trie() {
        root = new Node();

    }
    
    public void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1; // get the ith bit of the number
            if (!node.containsKey(bit)) {
                node.put(bit, new Node()); // if the bit is not present, create a new node

            }
            node = node.get(bit); // move to the next node
        }
    }
    
    public static int getMaxXor(int num) {
        Node node = root;
        int maxXor = 0;
        for (int i = 31; i > 0; i--) {
            int bit = (num >> i) & 1; // get the ith bit of the number
            if (node.containsKey(1 - bit)) { // if the opposite bit is present, take it
                maxXor |= (1 << i); // set the ith bit of maxXor
                node = node.get(1 - bit); // move to the next node
            } else {
                node = node.get(bit); // move to the next node
            }

        }
        return maxXor; // return the maximum XOR value
    }

}
public class maximumXORofTwoNumbers {
    public static void main(String[] args) {
        int[] arr = { 3, 10, 5, 25, 2, 8 };
        Trie trie = new Trie(); // create a trie
        for (int i = 0; i < arr.length; i++) {
            trie.insert(arr[i]); // insert the binary representation of the numbers in the trie
        }
        int maxXor = findMaximumXOR(arr); // find the maximum XOR by traversing the trie
        System.out.println("Maximum XOR of two numbers in the array is: " + maxXor); // print the maximum XOR value
    }
    public static int findMaximumXOR(int[] arr) {
        int maxXor = 0;
        for (int i = 0; i < arr.length; i++) {
            maxXor = Math.max(maxXor, Trie.getMaxXor(arr[i])); // find the maximum XOR by traversing the trie
        }
        return maxXor; // return the maximum XOR value
    }
}
