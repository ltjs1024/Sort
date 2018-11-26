package stone.insert;

import stone.SortHelper;

/**
 * 插入排序
 */
public class InsertionSort {

    private InsertionSort() {

    }

    public static void sort(Comparable[] arr) {
//        sort1(arr, 0, arr.length - 1);
//        sort2(arr, 0, arr.length - 1);
        binaryInsertSort(arr, 0, arr.length - 1);
    }

    // 对arr[left...right]进行插入排序
    private static void sort1(Comparable[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
//            for (int j = i; j > 0; j--) {
//                if (arr[j].compareTo(arr[j - 1]) < 0) {
//                    SortHelper.swap(arr, j, j - 1);
//                } else {
//                    break;
//                }
//            }
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                SortHelper.swap(arr, j - 1, j);
            }
            System.out.println(SortHelper.toString(arr));
        }
    }

    // 优化：减少数据交换次数
    public static void sort2(Comparable[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            Comparable v = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(v) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = v;
            System.out.println(SortHelper.toString(arr));
        }
    }

    // 优化： 折半插入排序
    private static void binaryInsertSort(Comparable[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int low = left;
            int high = i - 1;
            Comparable v = arr[i];
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid].compareTo(v) < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            for (int j = i; j > low; j--) {
                arr[j] = arr[j - 1];
            }
            arr[low] = v;
            System.out.println(SortHelper.toString(arr));
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SortHelper.printArray(arr);
        InsertionSort.sort(arr);
        SortHelper.printArray(arr);
    }

}
