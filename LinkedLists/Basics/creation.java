import java.util.Scanner;

class node {
    int data;
    node next;

    node(int n) {
        data = n;
        next = null;
    }
}

public class creation {
    static node head = null;

    public static node insert(int n) {
        node cur = new node(n);
        if (head == null) {
            head = cur;
        } else {
            node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = cur;
        }
        return cur;
    }
    
    
    static void display(node head) {
        node temp = head;
        // int c = 0;
        while (temp != null) {
            
            System.out.print(temp.data + "--> ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            // insert(sc.nextInt());
            node head = insert(sc.nextInt());
        }
        display(head);
        
    }
}
