import java.util.Random;

public class RadixSort {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(arr.length);
        }
      //  showArr(arr, 50);
        radixSort(arr);
       // showArr(arr, 50);
    }

    public static void radixSort(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCount = new int[10];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        int length = (max + "").length();
        for (int i = 0, n = 1; i < length; i++, n = n * 10) {
            for (int j = 0; j < arr.length; j++) {
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
                bucketElementCount[k] = 0;
            }
        }
    }

    public static void showArr(int[] arr,int length){
        for(int i=0;i<length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
