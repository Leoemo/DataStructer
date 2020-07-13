import jdk.jfr.StackTrace;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class InsertSort {

    //复杂化=_=
    @Test
    public void Test() {
        Random random = new Random();
        int[] origin = new int[10];
        for (int i = 0; i < origin.length; i++) {
            origin[i] = random.nextInt(50);
            System.out.print(origin[i] + " ");
        }
        System.out.println();

        int[] sorted = new int[origin.length];
        sorted[0] = origin[0];
        int curIndex = 1;//用于判定当前是第几个元素待插入
        while (curIndex < origin.length) {
            //首先判断是否插入到尾部元素
            if (origin[curIndex] > sorted[curIndex - 1])
                sorted[curIndex] = origin[curIndex];
                //再判断是否插入到最前端
            else if (origin[curIndex] < sorted[0]) {
                //先将已排序好的数据后移操作
                for (int i = curIndex; i > 0; i--) {
                    sorted[i] = sorted[i - 1];
                }
                //再插入到首元素
                sorted[0] = origin[curIndex];
            } else
            //否则去找到要插入的位置，再移动后排元素，并插入
            {
                for (int i = 0; i < curIndex; i++) {
                    if (origin[curIndex] <= sorted[i]) {
                        for (int j = curIndex - 1; j >= i; j--) {
                            sorted[j + 1] = sorted[j];
                        }
                        sorted[i] = origin[curIndex];
                        break;
                    }
                }
            }

            curIndex++;
        }

        System.out.println();
        for (int i = 0; i < origin.length; i++) {

            System.out.print(sorted[i] + " ");
        }
    }

    @Test
    //从小到大
    public void test2() {
        Random random = new Random();
        int[] origin = new int[10];
        for (int i = 0; i < origin.length; i++) {
            origin[i] = random.nextInt(50);
            System.out.print(origin[i] + " ");
        }
        System.out.println();

        int[] sorted = new int[origin.length];
        sorted[0] = origin[0];

        for (int i = 1; i < origin.length; i++) {

            int insertVal = origin[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < origin[insertIndex]) {
                origin[insertIndex + 1] = origin[insertIndex];
                insertIndex--;
            }
            origin[insertIndex + 1] = insertVal;
        }
        System.out.println(Arrays.toString(origin));


    }


    @Test
    public void test3() {
        //从大到小
        Random random = new Random();
        int[] origin = new int[10];
        for (int i = 0; i < origin.length; i++) {
            origin[i] = random.nextInt(50);
            System.out.print(origin[i] + " ");
        }
        System.out.println();

        int[] sorted = new int[origin.length];
        sorted[0] = origin[0];

        for (int i = 1; i < origin.length; i++) {

            int insertVal = origin[i];
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertVal > origin[insertIndex]) {
                origin[insertIndex + 1] = origin[insertIndex];
                insertIndex--;
            }
            origin[insertIndex + 1] = insertVal;
        }
        System.out.println(Arrays.toString(origin));


    }
}
