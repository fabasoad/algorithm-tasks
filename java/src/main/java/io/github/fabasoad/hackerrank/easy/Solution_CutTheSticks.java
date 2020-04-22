package io.github.fabasoad.hackerrank.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * https://www.hackerrank.com/challenges/cut-the-sticks/problem
 */
public class Solution_CutTheSticks {

    public static void main(String[] args) {
        int[] input = { 1, 13, 3, 8, 14, 9, 4, 4 };
        assert Arrays.equals(new int[] { 8, 7, 6, 4, 3, 2, 1 }, cutTheSticks(input));
    }

    static int[] cutTheSticks(int[] arr) {
        Arrays.sort(arr); // O(n*log(n))
        boolean cut = false;
        int[] min = { Integer.MAX_VALUE, 0 };
        int minIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && arr[i] < min[0]) {
                min[0] = arr[i];
                minIndex = i;
                break;
            }
        }
        if (minIndex == -1) {
            return new int[0];
        }
        Collection<Integer> result = new ArrayList<>();
        while (minIndex < arr.length) {
            result.add(arr.length - minIndex);
            for (int i = minIndex; i < arr.length; i++) {
                if (arr[i] == 0) {
                    continue;
                }
                arr[i] -= min[0];
                if (!cut && arr[i] != 0) {
                    cut = true;
                    min[1] = arr[i];
                    minIndex = i;
                }
                if (arr[i] == 0 && i == arr.length - 1) {
                    minIndex = i + 1;
                }
            }
            int temp = min[0];
            min[0] = min[1];
            min[1] = temp;
            cut = false;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
