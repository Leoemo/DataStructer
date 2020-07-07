import jdk.jshell.spi.ExecutionControl;

import java.util.Scanner;

/**
 * 数组模拟实现环形队列
 */
public class CircularQueue {
    //定义头尾指针,rear指向队尾元素的下一个位置
    private int front = 0,rear = 0;
    private int[] circularQueue ;

    public static void main(String[] args) {
        CircularQueue c = new CircularQueue(4);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("a-显示队列");
            System.out.println("b-弹出队首");
            System.out.println("c-添加队列");
            System.out.println("输入对应的选项");
            String s = scanner.nextLine();
            char c1 = s.charAt(0);
            switch (c1){
                case 'a':
                    c.showQueue();
                    break;
                case 'b':
                    int element = c.popQueue();
                    if(element != -1) {
                        System.out.println(element);
                    }
                    else {
                        System.out.println("队列为空");
                    }
                    break;
                    case 'c':
                    System.out.println("输入数字");
                    int i = Integer.parseInt(scanner.nextLine());
                    c.addToQueue(i);
                    break;
            }

        }
    }

    //利用构造器初始化队列长度为queueLength - 1
    public CircularQueue(int queueLength){
        circularQueue = new int[queueLength];
    }

    //添加元素到队列
    public void addToQueue(int element){
        if(!isFull()){
            circularQueue[rear] = element;
            //rear ++; 此处为了避免数组越界,需要取模将rear指针指到环形数组前端
            rear = (rear + 1) % circularQueue.length;
        }
        else
            System.out.println("队列已经满了，不可添加");
    }

    //弹出栈顶元素
    public int popQueue(){
        if(!isEmpty()) {
            int popElement = circularQueue[front];
            //front++; 此处为了避免数组越界,需要取模将front指针指到环形数组前端
            front = (front+1)%circularQueue.length;
            return popElement;
        }
        return -1;
    }

    //显示完整队列信息
    public void showQueue(){
        if(!isEmpty()) {
            //elementCounts 代表队列元素个数
            int elementCounts = (rear - front + circularQueue.length) % circularQueue.length;
            for (int i = front; i < front + elementCounts; i++) {
                System.out.println(circularQueue[i % circularQueue.length]);
            }
        }
        else
            System.out.println("队列为空");

    }
    //判读队列是否满
    private boolean isFull(){
        //elementCounts 代表队列元素个数
        int elementCounts = (rear-front+circularQueue.length) % circularQueue.length;
        if(elementCounts == circularQueue.length-1){
            return true;
        }
        return false;
    }
    //判读队列是否为空
    private boolean isEmpty(){
        //elementCounts 代表队列元素个数
        int elementCounts = (rear-front+circularQueue.length) % circularQueue.length;
        if(elementCounts == 0){
            return true;
        }
        return false;
    }


}
