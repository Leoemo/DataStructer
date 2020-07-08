public class LinkedListTest {

    USerNode headNode = new USerNode(0, null, 0, null);

    public static void main(String[] args) {
        USerNode node1 = new USerNode(1, "Hy", 23);
        USerNode node2 = new USerNode(4, "gm", 22);
        USerNode node3 = new USerNode(5, "hm", 25);
        USerNode node4 = new USerNode(3, "hm", 25);
        USerNode node5 = new USerNode(6, "hm", 25);

        LinkedListTest linkedListTest = new LinkedListTest();
        linkedListTest.addUserById(node1);
        linkedListTest.addUserById(node2);
        linkedListTest.addUserById(node3);
        linkedListTest.addUserById(node4);
        linkedListTest.addUserById(node5);

        linkedListTest.showUserById();

        linkedListTest.updateUserById(new USerNode(6, "update",55));
        linkedListTest.showUserById();

        linkedListTest.deleteUserById(1);
        linkedListTest.showUserById();

        linkedListTest.addUserById(node1);
        linkedListTest.showUserById();
    }

    public void deleteUserById(int id){
        USerNode temp = headNode;
        if(isEmpty()){
            System.out.println("链表为空，不能删除");
            return;
        }
        while(temp.next != null){
            if(temp.next.id == id){
                temp.next = temp.next.next;
                System.out.printf("删除成功,ID=%d\n",id);
                return;
            }
            temp = temp.next;
        }
        System.out.printf("找不到ID=%d的用户，无法删除\n",id);

    }

    public void updateUserById(USerNode newUser){
        USerNode temp  = headNode;
        if(isEmpty()) {
            System.out.println("链表为空，无法更新");
            return;
        }
        while (temp.next != null){
            if (temp.next.id == newUser.id){
                USerNode oldUser_next= temp.next.next;
                temp.next = newUser;
                newUser.next = oldUser_next;
                System.out.printf("更新成功,ID=%d\n",newUser.id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("根据ID没有找到可更新的用户");
    }


    public void showUserById() {
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        USerNode temp = headNode;
        while (temp.next != null) {
            System.out.println(temp.next);
            temp = temp.next;
        }

    }


    public void addUserById(USerNode uSerNode) {
        USerNode temp = headNode;
        if (isEmpty()) {
            headNode.next = uSerNode;
            return;
        }

        while (temp.next != null) {
            if (temp.next.id > uSerNode.id) {
                USerNode oldNext = temp.next;
                temp.next = uSerNode;
                uSerNode.next = oldNext;
                return;
            } else if (temp.next.id == uSerNode.id) {
                System.out.println("数据已存在，无法加入");
                return;
            }
            temp = temp.next;
        }
        temp.next = uSerNode;


    }

    private boolean isEmpty() {
        if (headNode.next == null) {
            return true;
        }
        return false;
    }

}


class USerNode {
    public int id;
    public String name;
    public int age;
    public USerNode next;

    public USerNode(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public USerNode(int id, String name, int age, USerNode next) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.next = next;
    }

    @Override
    public String toString() {
        return "USerNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
