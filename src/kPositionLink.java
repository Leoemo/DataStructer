public class kPositionLink {


    /**
     * 链表中倒数第k个节点
     *
     * @param args
     */
    public static void main(String[] args) {

        Node r = new Node(1);
        Node h = r;
        for (int i = 2; i < 20; i++) {
            r.next = new Node(i);
            r = r.next;
        }
        show(h);
        Node solve = solve(h, 1);
        System.out.println(solve);

        Node node = delSolve(h, 1);
        show(node);

    }

    public static void show(Node r) {
        if (r == null)
            System.out.println("链表为空");
        while (r != null) {
            System.out.print(r.val + " ");
            r = r.next;
        }
        System.out.println();
    }

    public static Node solve(Node head, int k) {
        Node first = head;
        Node second = head;
        int count = 0;
        while (first != null) {
            first = first.next;
            count++;
            if (count > k) {
                second = second.next;
            }
        }
        //如果节点数目少于k
        if (k > count)
            return null;
        return second;
    }

    /**
     * 删除链表的倒数第N个节点
     *
     * @param head
     * @param n
     * @return
     */
    public static Node delSolve(Node head, int n) {
        Node first = head;
        Node second = head;
        int count = 0;
        while (first != null) {
            first = first.next;
            count++;
            //先将second指针遍历至要删除的前一个节点
            if (count > (n + 1)) {
                second = second.next;
            }
        }
        //特殊情况，处理删除第一位的返回指针为second.next
        if (count == n)
            return second.next;
        second.next = second.next.next;
        return head;
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
