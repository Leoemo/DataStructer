public class addSortedLink {
    /**
     * 合并两个排序的链表
     */
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(5);
        Node n3 = new Node(8);
        Node n4 = new Node(2);
        Node n5 = new Node(3);
        Node n6 = new Node(9);
        n1.next = n2;
        n2.next = n3;//1->5->8

        n4.next = n5;//2->3->9
        n5.next = n6;

        Node solve = solve(n1, n4);

        while (solve != null) {
            System.out.print(solve.val + "->");
            solve = solve.next;
        }
    }

    public static Node solve(Node r1, Node r2) {
        Node dumb = new Node(0);
        Node head = dumb;
        while (r1 != null || r2 != null) {
            while (r1 != null && r2 != null) {
                if (r1.val < r2.val) {
                    head.next = r1;
                    r1 = r1.next;

                } else {
                    head.next = r2;
                    r2 = r2.next;
                }
                head = head.next;
            }
            if (r1 != null) {
                head.next = r1;
                break;
            }
            if (r2 != null) {
                head.next = r2;
                break;
            }
        }
        return dumb.next;
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
}
