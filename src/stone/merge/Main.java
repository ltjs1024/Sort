package stone.merge;

import stone.SortHelper;

/**
 * 测试MergeSort
 */
public class Main {
    public static void main(String[] args) {

        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int N = 1000000;
        Integer[] arr = SortHelper.generateRandomArray(N, 0, 100000);
        SortHelper.testSort("stone.merge.MergeSort", arr);

    }
}
