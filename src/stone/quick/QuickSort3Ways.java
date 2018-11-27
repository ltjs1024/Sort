package stone.quick;

import stone.SortHelper;
import stone.insert.InsertionSort;

public class QuickSort3Ways {
    private QuickSort3Ways() {

    }

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    // 对arr[lo...hi]进行快速排序
    private static void sort(Comparable[] arr, int lo, int hi) {
        // 对于小规模数组, 使用插入排序
        if (hi - lo <= 15) {
            InsertionSort.sort(arr, lo, hi);
            return;
        }
        // 对arr[lo...hi]进行partition操作，返回p
        // 使得arr[lo...p] < arr[p] ; arr[p+1...hi] > arr[p]
        int lt = lo;
        int gt = hi;
        SortHelper.swap(arr, lo, (int) (Math.random() * (hi - lo + 1)) + lo);
        Comparable v = arr[lo];
        int i = lo + 1;
        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                SortHelper.swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i].compareTo(v) > 0) {
                SortHelper.swap(arr, i, gt - 1);
                gt--;
            }else {
                i++;
            }

        }

        SortHelper.swap(arr, lo, lt);
        sort(arr, lo, lt - 1);
        sort(arr, gt, hi);
    }


    // 测试 QuickSort
    public static void main(String[] args) {

        // 三路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortHelper.generateRandomArray(N, 0, 100000);
        SortHelper.testSort("stone.quick.QuickSort3Ways", arr);

    }
}
