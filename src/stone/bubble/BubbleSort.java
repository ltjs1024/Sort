package stone.bubble;

import stone.SortHelper;

public class BubbleSort {
    private BubbleSort() {

    }

    public static void sort(Comparable[] arr) {
        sort2(arr);
    }

    public static void sort1(Comparable[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            boolean flag = false;
            for (int j = 1; j < length - i; j++) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    SortHelper.swap(arr, j - 1, j);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
            System.out.println(SortHelper.toString(arr));
        }
    }

    public static void sort2(Comparable[] arr) {
        int n = arr.length;
        boolean flag = false;
        do {
            flag = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    SortHelper.swap(arr, i - 1, i);
                    flag = true;
                }
            }
            // 优化, 每一趟Bubble Sort都将最大的元素放在了最后的位置
            // 所以下一次排序, 最后的元素可以不再考虑
            n--;
        } while (flag);
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SortHelper.printArray(arr);
        BubbleSort.sort(arr);
        SortHelper.printArray(arr);
    }
}
