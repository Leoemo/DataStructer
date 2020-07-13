

import java.util.Random;

/**
 * @author leoemo
 * @create 2020-6-19-
 */
public class SelectionSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] origin = new int[10];
        for (int i = 0; i < 10; i++) {
            origin[i] = random.nextInt(50);
            System.out.print(origin[i] + ",");
        }
        System.out.println();

        SelectionSort selectionSort = new SelectionSort();
        int[] sorted = selectionSort.selectionSort(origin);
        for (int i = 0; i < 10; i++) {
            System.out.print(sorted[i] + ",");
        }


    }


    private int[] selectionSort(int[] sort) {
        for (int i = 0; i < sort.length - 1; i++) {

            int min_index = i;
            for (int j = i + 1; j < sort.length; j++) {
                if (sort[j] < sort[min_index]) {
                    min_index = j;
                }

            }
            int temp = sort[min_index];
            sort[min_index] = sort[i];
            sort[i] = temp;

        }

        return sort;
    }


}

