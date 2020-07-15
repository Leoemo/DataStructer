import java.util.Random;

public class RadixSort {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(arr.length);
        }
        //  showArr(arr, 50);
        radixSort(arr);
        // showArr(arr, 50);

    }

    //基数排序
    public static void radixSort(int[] arr) {
        //定义桶个数（一维长度），二维长度尽可能大，避免所有值相同的情况
        int[][] bucket = new int[10][arr.length];
        //bucketElementCount：保存每个桶当前含有元素个数的数组
        int[] bucketElementCount = new int[10];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        //找出待排序数组中最大值的位数
        int length = (max + "").length();
        for (int i = 0, n = 1; i < length; i++, n = n * 10) {
            for (int j = 0; j < arr.length; j++) {
                //得到个十百千位，进行比较....
                int index = arr[j] / n % 10;
                bucket[index][bucketElementCount[index]] = arr[j];
                bucketElementCount[index]++;
            }
            int arrIndex = 0;
            for (int k = 0; k < bucketElementCount.length; k++) {
                if (bucketElementCount[k] != 0) {
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                        arr[arrIndex++] = bucket[k][l];
                    }
                }
                //进行下一位比较前清空桶元素个数统计数组
                bucketElementCount[k] = 0;
            }
        }
    }

    public static void showArr(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
