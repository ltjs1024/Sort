package stone.merge;

import stone.SortHelper;
import stone.insert.InsertionSort;

import java.util.Arrays;

public class MergeSort {
    private MergeSort() {

    }

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    // 对arr[lo...hi]进行合并排序
    private static void sort(Comparable[] arr, int lo, int hi) {
//        if (lo >= hi) {
//            return;
//        }
        if (hi - lo <= 15) {
            InsertionSort.sort(arr, lo, hi);
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);

        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            mergeSort(arr, lo, mid, hi);
        }
    }

    // 将arr[lo...mid]和arr[mid+1...hi]两部分进行归并
    private static void mergeSort(Comparable[] arr, int lo, int mid, int hi) {
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
        Integer[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SortHelper.printArray(arr);
        MergeSort.sort(arr);
        SortHelper.printArray(arr);
    }
}
