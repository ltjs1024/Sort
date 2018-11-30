package stone.insert;

import stone.SortHelper;

public class Main {

    public static void main(String[] args) {

        int N = 100000;
        Integer[] arr = SortHelper.generateRandomArray(N, 0, 100000);
        SortHelper.testSort("stone.insert.InsertionSort", arr);

    }
}
