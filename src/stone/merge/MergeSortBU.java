package stone.merge;

import stone.SortHelper;

import java.util.Arrays;

public class MergeSortBU {

    private MergeSortBU() {
    }

    public static void sort(Comparable[] arr) {
        sort(arr, arr.length - 1);
    }

    // 对arr[0...n]进行归并排序
    private static void sort(Comparable[] arr, int n) {
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                // 对arr[i...i+sz-1]和arr[i+sz...i+2*sz-1]进行归并
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }

    }

    private static void merge(Comparable[] arr, int lo, int mid, int hi) {
        Comparable[] aux = Arrays.copyOfRange(arr, lo, hi + 1);
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = aux[j - lo];
                j++;
            } else if (j > hi) {
                arr[k] = aux[i - lo];
                i++;
            } else if (aux[i - lo].compareTo(aux[j - lo]) > 0) {
                arr[k] = aux[j - lo];
                j++;
            } else {
                arr[k] = aux[i - lo];
                i++;
            }
        }
    }

    public static void main(String[] args) {
//        Integer[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Integer[] arr = {8, 6, 2, 3, 1, 5, 7, 4};
        SortHelper.printArray(arr);
        MergeSortBU.sort(arr);
        SortHelper.printArray(arr);
    }
}
