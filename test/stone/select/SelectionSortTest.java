package stone.select;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stone.SortHelper;

import java.util.Arrays;


public class SelectionSortTest {

    private Integer[] arr;
    private Integer[] largeArr;

    @Before
    public void setup() {
        arr = new Integer[]{8, 3, 4, 2, 1, 5, 7, 6};

        int N = 20000;
        largeArr = SortHelper
                .generateRandomArray(N, 0, 100000);
    }

    @Test
    public void testSort1() {
        SelectionSort.sort1(arr);
        String expected = "[1, 2, 3, 4, 5, 6, 7, 8]";
        Assert.assertEquals(expected, Arrays.toString(arr));
    }

    @Test
    public void testSort2() {
        SelectionSort.sort2(arr);
        String expected = "[1, 2, 3, 4, 5, 6, 7, 8]";
        Assert.assertEquals(expected, Arrays.toString(arr));
    }

    @Test
    public void testSort3() {
        SelectionSort.sort3(arr);
        String expected = "[1, 2, 3, 4, 5, 6, 7, 8]";
        Assert.assertEquals(expected, Arrays.toString(arr));
    }

    @Test
    public void testSort() {
        SortHelper.
                testSort("stone.select.SelectionSort", largeArr);
    }
}
