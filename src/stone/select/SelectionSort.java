package stone.select;

import static stone.SortHelper.swap;

/**
 * 选择排序
 */
public class SelectionSort {
    private SelectionSort() {

    }

    public static void sort(Comparable[] arr) {
        sort3(arr);
    }


    protected static void sort1(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[i]) < 0) {
                    swap(arr, i, j);
                }
            }
//            System.out.println(SortHelper.toString(arr));
        }
    }

    // 优化：在每一轮中，找到最小值的索引后，然后交换数据
    protected static void sort2(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
//            System.out.println(SortHelper.toString(arr));
        }
    }

    // 优化：在每一轮中, 可以同时找到当前未处理元素的最大值和最小值
    protected static void sort3(Comparable[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int minIndex = left;
            int maxIndex = right;

            if (arr[minIndex].compareTo(arr[maxIndex]) > 0) {
                swap(arr, minIndex, maxIndex);
            }

            for (int i = left + 1; i < right; i++) {
                if (arr[i].compareTo(arr[minIndex]) < 0) {
                    minIndex = i;
                } else if (arr[i].compareTo(arr[maxIndex]) > 0) {
                    maxIndex= i;
                }
            }
            swap(arr, minIndex, left);
            swap(arr, maxIndex, right);

//            System.out.println(SortHelper.toString(arr));

            left++;
            right--;
        }
    }


}
