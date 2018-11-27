package stone.quick;

import stone.SortHelper;

/**
 * 快速排序
 */
public class QuickSort {
    private QuickSort() {
    }

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    // 对arr[lo...hi]进行快速排序
    private static void sort(Comparable[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        // 对arr[lo...hi]进行partition操作，返回p
        // 使得arr[lo...p] < arr[p] ; arr[p+1...hi] > arr[p]
        int p = partition(arr, lo, hi);

        sort(arr, lo, p - 1);
        sort(arr, p + 1, hi);
    }

    private static int partition(Comparable[] arr, int lo, int hi) {
        Comparable v = arr[lo];
        int p = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (arr[i].compareTo(v) < 0) {
                SortHelper.swap(arr, i, p + 1);
                p++;
//                System.out.println(SortHelper.toString(arr));
            }
        }
        SortHelper.swap(arr, lo, p);
//        System.out.println(SortHelper.toString(arr));
//        System.out.println("----------------------");
        return p;
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 9, 8, 7};
        QuickSort.sort(arr);
        System.out.println(SortHelper.toString(arr));
    }
}
