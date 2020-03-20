package youtube;

import java.util.Arrays;

public class SortingTest {

    public static void main(String[] args) {
        var arr = new int[] { 1, 34, 2, 33, 3, 6 };
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // O(n^2)
    public static void selectionSort(final int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            var min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min > i) {
                var temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
