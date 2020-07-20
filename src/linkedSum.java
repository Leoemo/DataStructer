public class linkedSum {


    public static void main(String[] args) {
        Node n1 = new Node(2);
        Node n2 = new Node(4);
        Node n3 = new Node(3);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        Node n6 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        n5.next = n6;
        Node solve = solve(n1, n4);
        while (solve != null) {
            System.out.println(solve.val);
            if (solve.next == null)
                break;
            solve = solve.next;
        }


    }

    public static Node solve(Node p, Node q) {
        Node head = new Node(0);
        Node cur = head;
        int carry = 0;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int r = x + y + carry;
            cur.next = new Node(r % 10);
            carry = r / 10;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
            cur = cur.next;
        }
        if (carry > 0) {
            cur.next = new Node(carry);
        }
        return head.next;
    }


    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }


    }
}
