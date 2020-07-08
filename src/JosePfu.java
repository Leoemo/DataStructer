public class JosePfu {
    public static void main(String[] args) {

        cycleList c = new cycleList();
        c.addBoy(10);
        c.showBoys();
        //从第start小孩开始,间隔2出列
        c.outputOrder(2, 2);
    }


}
//实现单向循环队列,其实用双向循环队列更容易解决约瑟夫问题,因为可以去除辅助指针的引用
class cycleList {
    Boy first = null;
    Boy curBoy = null;

    //构造指定个数的小孩
    public void addBoy(int num) {
        for (int i = 1; i <= num; i++) {
            if (first == null) {
                first = new Boy(i);
                curBoy = first;
                continue;
            }
            curBoy.next = new Boy(i);
            curBoy = curBoy.next;
        }
        curBoy.next = first;
    }

    //显示所有小孩
    public void showBoys() {
        curBoy = first;
        while (true) {
            System.out.println(curBoy);
            curBoy = curBoy.next;
            if (curBoy == first)
                break;
        }
    }

    //按照指定要求出队小孩，显示小孩编号
    public void outputOrder(int start, int k) {
        curBoy = first;
        Boy help = first;
        //这里只循环start-1次,使得辅助指针help指向实际起始小孩的前一位
        for (int i = 0; i < start - 1; i++) {
            help = help.next;
        }
        //将curBoy指针起始小孩
        for (int i = 0; i < start ; i++) {
            curBoy = curBoy.next;
        }

        System.out.println("小孩出列顺序为");
        while (true) {
            //移动指定的间隔，进一步挑选出要出列的小孩
            for (int i = 0; i < k - 1; i++) {
                curBoy = curBoy.next;
                help = help.next;
            }
            //打印出列小孩ID
            System.out.print(curBoy.id+"->");
            //重新链接链表
            curBoy = curBoy.next;
            help.next = curBoy;
            //判断小孩是否是最后一个
            if (curBoy == help) {
                System.out.print(curBoy.id);
                break;
            }
        }
    }


}

class Boy {
    int id;
    Boy next;

    public Boy(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                '}';
    }
}