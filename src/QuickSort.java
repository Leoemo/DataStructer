import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        /**
         * 生成随机数组，并调用快排递归方法
         */
        Random random = new Random(100);
        int origin[] = new int[20];
        for(int i =0;i<20;i++){
            origin[i] = random.nextInt(100);
            System.out.print(origin[i]+",");
        }
        System.out.println();
        QuickSort sortInstant = new QuickSort();
        int[] sorted = sortInstant.quickSort(origin,0,origin.length-1);
        for(int i :sorted){
            System.out.print(i+",");
        }

    }

    /**
     *
     * @param sort 待排序数组
     * @param l    数组最左边界，0
     * @param r   数组右边界
     * @return    返回排序后的数组
     */
    public int[] quickSort(int[] sort,int l,int r){
        if(l<r){
            int index = adjustArray(sort,l,r);
            quickSort(sort,l,index-1);
            quickSort(sort,index+1,r);
        }
        return sort;
    }

    /**
     *获取每一层递归过程中数组的中间基数下标，用于将大数组分成两个小数组继续递归
     */
    public int adjustArray(int[] sort,int l,int r){
        int i = l ,j = r;
        int x = sort[l];
        while(i<j){
            while(i<j && sort[j]>=x){
                j--;
            }
            if(i<j && sort[j]<x){
                sort[i] = sort[j];
                i++;

            }
            while(i<j && sort[i]<=x){
                i++;
            }
            if(i<j && sort[i]>x){
                sort[j] = sort[i];
                j--;
            }
        }
        sort[i] = x;

        return i;
    }
}
