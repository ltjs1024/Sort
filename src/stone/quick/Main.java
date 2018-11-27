package stone.quick;

import stone.SortHelper;

public class Main {

    // 测试 QuickSort
    public static void main(String[] args) {
        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortHelper.generateRandomArray(N, 0, 100000);
        SortHelper.testSort("stone.quick.QuickSort", arr);

    }
}
