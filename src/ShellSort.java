import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class ShellSort {

    public static void main(String[] args) {
        Random random = new Random();
        int[] dataBig1 = new int[80000];
        for (int i = 0; i < 80000; i++) {
            dataBig1[i] = random.nextInt(80000);
        }

        int[] dataBig2 = dataBig1.clone();
        int[] dataBig3 = dataBig1.clone();

        System.out.println("排序前");
        showSorted(dataBig1);
        showSorted(dataBig2);
        showSorted(dataBig3);

        //分三种方法进行排序
        shellSort1(dataBig1);
        shellSort2(dataBig2);
        shellSort3(dataBig3);

        System.out.println("排序后");

        showSorted(dataBig1);
        showSorted(dataBig2);
        showSorted(dataBig3);
    }

    /*
     没有优化的shell排序,内部判断类似于冒泡排序
     */
    public static void shellSort1(int[] data) {
        int temp = 0;
        //每次分组间隔长度依次减半
        int gap = data.length / 2;

        long start = System.currentTimeMillis();

        while (gap > 0) {
            for (int i = gap; i < data.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    //类冒泡排序,不断的交换导致运行缓慢
                    if (data[j] > data[j + gap]) {
                        temp = data[j];
                        data[j] = data[j + gap];
                        data[j + gap] = temp;
                    }
                }
            }
            gap = gap / 2;
        }
        long stop = System.currentTimeMillis();
        long runTime = stop - start;
        System.out.println("所用时间(ms)：" + runTime);
    }

    /*
    /在普通shell基础上,加上判断条件，避免不必要的循环进入
     */
    public static void shellSort2(int[] data) {
        int temp = 0;
        //每次分组间隔长度依次减半
        int gap = data.length / 2;

        long start = System.currentTimeMillis();

        while (gap > 0) {
            for (int i = gap; i < data.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (data[j] > data[j + gap]) {
                        temp = data[j];
                        data[j] = data[j + gap];
                        data[j + gap] = temp;
                        //一旦数据还没到插入位置，继续循环
                        continue;
                    }
                    //如果插入排序找到了某个位置已经是满足了，就不用再往前找了，因为前面的已经有序了
                    break;
                }
            }
            gap = gap / 2;

        }

        long stop = System.currentTimeMillis();
        long runTime = stop - start;
        System.out.println("所用时间(ms)：" + runTime);
    }

    //优化的Shell排序,将内部判断改用移动法（类插入排序）
    public static void shellSort3(int[] data) {
        int gap = data.length / 2;
        int length = data.length;
        long start = System.currentTimeMillis();
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                int j = i;
                int temp = data[i];
                //此处可避免冒泡法导致的多次赋值，加快运行速度
                while (j - gap >= 0 && temp < data[j - gap]) {
                    data[j] = data[j - gap];
                    j = j - gap;
                }
                data[j] = temp;
            }
            gap = gap / 2;
        }
        long stop = System.currentTimeMillis();
        long runTime = stop - start;
        System.out.println("所用时间(ms)：" + runTime);
    }

    public static void showSorted(int[] data) {
        for (int i = 0; i < 20; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
