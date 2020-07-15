import java.util.ArrayList;
import java.util.Arrays;

public class SearchMethod {


    public static void main(String[] args) {


        int[] arr = new int[]{1, 2, 3, 4, 5, 5, 6, 7, 7, 7, 7, 7, 9, 10,10};
        ArrayList<Integer> arrayList = linearSearch(arr, 0, arr.length - 1, 5);
        System.out.println(arrayList);

        ArrayList<Integer> arrayList1 = interSearch(arr, 0, arr.length - 1, 5);
        System.out.println(arrayList1);

        fibonacciSearch(arr, 0, arr.length - 1, 10);

    }

    //线性查找算法
    public static ArrayList<Integer> linearSearch(int[] arr, int l, int r, int valSeek) {
        if (l > r) {
            return new ArrayList<>();
        }
        ArrayList<Integer> arrayList = new ArrayList();
        int mid = (l + r) / 2;
        int tempIndex = 0;
        if (valSeek < arr[mid]) {
            return linearSearch(arr, l, mid - 1, valSeek);
        } else if (valSeek > arr[mid]) {
            return linearSearch(arr, mid + 1, r, valSeek);
        } else {
            tempIndex = mid;
            //当存在重复数值时，从第一个找到的下标位置依次向左扫描，并将下标加到list
            while (tempIndex >= l && arr[tempIndex] == valSeek) {
                arrayList.add(tempIndex);
                tempIndex--;
            }
            tempIndex = mid + 1;
            //当存在重复数值时，从第一个找到的下标位置的下一个位置(避免重复，向左扫描已经添加过)依次向右扫描，并将下标加到list
            while (tempIndex <= r && arr[tempIndex] == valSeek) {
                arrayList.add(tempIndex);
                tempIndex++;
            }
        }
        return arrayList;

    }

    //插值查找算法
    public static ArrayList<Integer> interSearch(int[] arr, int l, int r, int valSeek) {

        if (l > r) {
            return new ArrayList<>();
        }
        int mid = l + (valSeek - arr[l]) / (arr[r] - arr[l]) * (r - l);
        int tempIndex = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (valSeek < arr[mid]) {
            return interSearch(arr, l, mid - 1, valSeek);
        } else if (valSeek > arr[mid]) {
            return interSearch(arr, mid + 1, r, valSeek);
        } else {
            tempIndex = mid;
            while (tempIndex >= l && arr[tempIndex] == valSeek) {
                arrayList.add(tempIndex);
                tempIndex--;
            }
            tempIndex = mid + 1;
            while (tempIndex <= r && arr[tempIndex] == valSeek) {
                arrayList.add(tempIndex);
                tempIndex++;
            }
        }
        return arrayList;
    }

    //斐波那契查找算法(黄金分割点)
    public static void fibonacciSearch(int[] arr, int l, int r, int valSeek) {

        int[] fibonacci = new int[200];
        int k = 0;
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        //构建一个合适大小的斐波那契数列
        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        //找到某个斐波那契值，其值-1等于待查找数组长度(可能不一定等，需要扩容)
        while (fibonacci[k] - 1 < arr.length) {
            k++;
        }
        //因为待查找数组的长度不一定刚好等于斐波那契数-1，因此需要先进行扩容
        int[] temp = Arrays.copyOf(arr, fibonacci[k]);
        //扩容后多出来的位置用原来数组中尾部元素填充
        for (int i = arr.length; i < fibonacci[k]; i++) {
            temp[i] = arr[arr.length - 1];
        }
        //使用递归或者循环方法查找
        ArrayList<Integer> i = fibonacciSearchRecursion(arr, temp, fibonacci, k, l, r, valSeek);
        ArrayList<Integer> i1 = fibonacciSearchRecursion2(arr, temp, fibonacci, k, l, r, valSeek);

        //打印查找值的下标位置
        System.out.println("index:" + i);
        System.out.println("index:" + i1);

    }

    public static ArrayList<Integer> fibonacciSearchRecursion(int[] arr, int[] temp, int[] fib, int k, int l, int r, int valSeek) {
        //递归停止条件
        if (l > r) {
            return new ArrayList<>();
        }
        /**
         * 因为斐波那契数列满足f[k] = f[k-1]+f[k-2]，所以可推出f[k]-1 = (f[k-1]-1) + (f[k-2]-1) + 1,也就是f[k]-1长度的数组可以恰
         * 好可以分成f[k-1]-1 和f[k-2] -1 左右两部分，其中f[k]-1 = (f[k-1]-1) + (f[k-2]-1) + 1中的1就是mid元素位置
         */
        ArrayList<Integer> arrayList = new ArrayList<>();
        int tempIndex = 0;
        int mid = l + fib[k - 1] - 1;
        if (valSeek < temp[mid]) {
            //向右递归
            return fibonacciSearchRecursion(arr, temp, fib, k - 1, l, mid - 1, valSeek);
        } else if (valSeek > temp[mid]) {
            //向左递归
            return fibonacciSearchRecursion(arr, temp, fib, k - 2, mid + 1, r, valSeek);
        } else if (mid <= arr.length)  //查询值所对应的下标没有超出未补充数组范围，因此下标就是原数组中的下标
        {

            tempIndex = mid;
            while (tempIndex >= l && arr[tempIndex] == valSeek) {
                arrayList.add(tempIndex);
                tempIndex--;
            }
            tempIndex = mid + 1;
            while (tempIndex <= r && arr[tempIndex] == valSeek) {
                arrayList.add(tempIndex);
                tempIndex++;
            }
            return arrayList;

        }
        else ////查询值所对应的下标进入补充数组的范围，因此查询的数据就是原数组尾部数据，因此返回原数组尾部数据对应的位置
        {
            //因为已经是尾部数据了，只需要向左扫描相同值就行了
            tempIndex = arr.length-1;
            while (tempIndex >= l && arr[tempIndex] == valSeek) {
                arrayList.add(tempIndex);
                tempIndex--;
            }
            return arrayList;
        }
    }

    public static ArrayList<Integer> fibonacciSearchRecursion2(int[] arr, int[] temp, int[] fib, int k, int l, int r, int valSeek) {
        //同上.....不想写了=_=

        int tempIndex = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (l <= r) {
            int mid = l + fib[k - 1] - 1;
            if (valSeek < temp[mid]) {
                r = mid - 1;
                k--;
            } else if (valSeek > temp[mid]) {
                l = mid + 1;
                k = k - 2;
            } else if (mid <= arr.length - 1) {
                {
                    tempIndex = mid;
                    while (tempIndex >= l && arr[tempIndex] == valSeek) {
                        arrayList.add(tempIndex);
                        tempIndex--;
                    }
                    tempIndex = mid + 1;
                    while (tempIndex <= r && arr[tempIndex] == valSeek) {
                        arrayList.add(tempIndex);
                        tempIndex++;
                    }
                    break;
                }

            } else {
                //因为已经是尾部数据了，只需要向左扫描相同值就行了
                tempIndex = arr.length-1;
                while (tempIndex >= l && arr[tempIndex] == valSeek) {
                    arrayList.add(tempIndex);
                    tempIndex--;
                }
                break;
            }
        }
        return arrayList;
    }


}
