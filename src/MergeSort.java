import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = new int[100000000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(arr.length);
        }
        System.out.println("原始数组：");
        showSomeArr(arr);

        int[] sortedArr = mergeSort(arr);
        System.out.println("排序后：");
        showSomeArr(sortedArr);
    }

    public static int[] mergeSort(int[] arr) {
        int length = arr.length;
        int[] result = new int[length];
        mergeSortRecursion(arr, result, 0, length - 1);
        return result;
    }

    public static void mergeSortRecursion(int[] arr, int[] result, int start, int end) {
        //不可再分时停止递归
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        int start1 = start;
        int end1 = mid;
        int start2 = mid + 1;
        int end2 = end;

        //先继续分解左边序列
        mergeSortRecursion(arr, result, start1, end1);
        //再分解右边序列
        mergeSortRecursion(arr, result, start2, end2);

        int k = start;
        //先将左右序列最小长度子序列进行排序，合并
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        //若左边序列有剩余，直接拷贝后续数据
        while (start1 <= end1) {
            result[k++] = arr[start1++];
        }
        //若右边序列有剩余，直接拷贝后续数据
        while (start2 <= end2) {
            result[k++] = arr[start2++];
        }
        //将本轮合并数据更新到原数组中
        for (k = start; k <= end; k++) {
            arr[k] = result[k];
        }

        //System.out.printf("本轮子序列起始结束为：start=%d,end=%d\n",start,end);
    }

    //数据超过10时打印一部分看看
    public static void showSomeArr(int[] arr) {
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
