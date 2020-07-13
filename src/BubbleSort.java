import org.junit.Test;

import java.util.Random;

/**
 * @author leoemo
 * @create 2020-6-16-15:27
 */
public class BubbleSort {

    //冒泡排序
    @Test
    public void Test1() {
        Random random = new Random();
        int[] origin = new int[20];
        for(int i=0;i<20;i++){
            origin[i] = random.nextInt(50);
            System.out.print(origin[i]+" ");
        }

//        int[] origin = new int[5];
//        origin[0] = 1;
//        origin[1] = 2;
//        origin[2] = 3;
//        origin[3] = 5;
//        origin[4] = 4;

        //flag用于指示某次内循环已经达到有序数组了，满足条件则不再继续排序，优化时间复杂度
        int flag ;
        int count = 0;
        for (int i = 0; i < origin.length - 1; i++) {
            flag = 0;
            for (int j = 0; j < origin.length - 1 - i; j++) {

                if (origin[j] > origin[j + 1]) {
                    int temp = origin[j + 1];
                    origin[j + 1] = origin[j];
                    origin[j] = temp;
                    flag = 1;
                }
            }
            count++;
            if (flag == 0)
                break;

        }
        System.out.println("循环次数：" + count);

        for (int i = 0; i < origin.length; i++) {
            System.out.print(origin[i] + " ");
        }


    }

}
