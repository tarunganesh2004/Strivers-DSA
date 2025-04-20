class node {
    int data;
    node next;
    node prev;

    node(int n) {
        data = n;
        next = null;
        prev = null;
    }
}
public class arrayToDoubleLL {
    static node insert(int[] a) {
        // node head = null;
        node head = new node(a[0]);
        node cur = head;
        for (int i = 1; i < a.length; i++) {
            node temp = new node(a[i]);
            cur.next = temp;
            temp.prev = cur;
            cur = cur.next;
            // if (cur.next == null) {
            //     break;
            // }
        }
        // head = cur;
        return head;
    }

    public static void print(node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;

        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4 };
        node head = insert(a);
         
        print(head);
    }
}
