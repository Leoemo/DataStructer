public class QueueChessBoard {

    static int[] queue = new int[8];

    public static void main(String[] args) {
        addQueue(0);
    }
    //检查第n+1位皇后位置是否和前n个有冲突
    public static boolean check(int n) {
        for (int i = 0; i < n; i++) {
            if (Math.abs(n - i) == Math.abs(queue[i] - queue[n]) || queue[n] == queue[i]) {
                return false;
            }
        }
        return true;
    }

    //递归添加满足条件的皇后
    public static void addQueue(int n) {

        if (n == 8) {
            printQueue();
            return;
        }
        //每一层皇后默认从第一列开始，后续每一皇后也是从第一列开始，并且要满足不冲突条件，直到得到第一次合理的位置信息，再反向回溯，即从最后一个皇后变换位置，寻找满足条件的位置
        for (int i = 0; i < 8; i++) {
            queue[n] = i;
            if (check(n)) {
                addQueue(n + 1);
            }
        }
    }

    private static void printQueue() {
        for (int i = 0; i < 8; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}
