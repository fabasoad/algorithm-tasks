package com.fabasoad.hackerrank.easy;

import java.util.function.Consumer;

/**
 * https://www.hackerrank.com/challenges/angry-children/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 */
public class Solution_MaxMin {

    public static void main(String[] args) {
        assert 20 == maxMin(3, new int[] { 10, 100, 300, 200, 1000, 20, 30 });
        assert 3 == maxMin(4, new int[] { 1, 2, 3, 4, 10, 20, 30, 40, 100, 200 });
        assert 0 == maxMin(2, new int[] { 1, 2, 1, 2, 1 });
        assert 816 == maxMin(8, new int[] {
            6327,
            571,
            6599,
            479,
            7897,
            9322,
            4518,
            571,
            6677,
            7432,
            815,
            6920,
            4329,
            4104,
            7775,
            5708,
            7991,
            5802,
            8619,
            6053,
            7539,
            7454,
            9000,
            3267,
            6343,
            7165,
            4095,
            439,
            5621,
            4095,
            153,
            1948,
            1018,
            6752,
            8779,
            5267,
            2426,
            9649,
            2190,
            9103,
            7081,
            3006,
            2376,
            7762,
            3462,
            151,
            3471,
            1453,
            2305,
            8442
        });
    }

    static int maxMin(int k, int[] arr) {
        int[] min = { Integer.MAX_VALUE };
        calcCombinations(arr, k, (data) -> {
            int mi = Integer.MAX_VALUE, ma = Integer.MIN_VALUE;
            for (int el : data) {
                mi = Math.min(el, mi);
                ma = Math.max(el, ma);
            }
            min[0] = Math.min(ma - mi, min[0]);
        });
        return min[0];
    }

    private static void combinationUtil(
        int[] arr, int[] data, int start, int end, int index, int r, Consumer<int[]> callback) {
        if (index == r) {
            callback.accept(data);
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r, callback);
        }
    }

    private static void calcCombinations(int[] arr, int r, Consumer<int[]> callback) {
        int[] data = new int[r];
        combinationUtil(arr, data, 0, arr.length - 1, 0, r, callback);
    }
}
