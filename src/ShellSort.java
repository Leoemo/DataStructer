import org.junit.Test;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] data = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(data);
    }

    public static void shellSort(int[] data) {
        int temp = 0;
        //每次分组间隔长度依次减半
        int groupLength = data.length / 2;
        while (groupLength > 0) {
            for (int i = groupLength; i < data.length; i++) {
                for (int j = i - groupLength; j >= 0; j -= groupLength) {
                    if (data[j] > data[j + groupLength]) {
                        temp = data[j];
                        data[j] = data[j + groupLength];
                        data[j + groupLength] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(data));
            groupLength = groupLength / 2;
        }
    }
}
