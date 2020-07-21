public class reverseLink {

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        show(n1);
        Node solve = solve(n1);
        show(solve);

    }


    public static void show(Node r) {
        while (r != null) {
            System.out.print(r.val + " ");
            r = r.next;
        }
        System.out.println();
    }

    public static Node solve(Node head) {
        Node pre = null;
        Node next;

        if (head.next == null) {
            return head;
        }
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }


    }
}
