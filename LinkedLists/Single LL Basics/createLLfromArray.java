class node {
    int data;
    node next;

    node(int n) {
        data = n;
        next = null;
    }
}

// static node head = null;

public class createLLfromArray {
    public static node createLL(int[] arr) {
        node cur = new node(arr[0]);
        node head = cur;
        for (int i = 1; i < arr.length; i++) {
            node temp = new node(arr[i]);
            cur.next = temp;
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4 };
        node head = createLL(a);
        System.out.println(head.next.next.data);
    }
}