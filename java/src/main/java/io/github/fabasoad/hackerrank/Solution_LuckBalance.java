package io.github.fabasoad.hackerrank;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/luck-balance/problem
 */
public class Solution_LuckBalance {

    public static void main(String[] args) {
        final var actual = luckBalance(3, new int[][] {
            new int[] { 5, 1 },
            new int[] { 2, 1 },
            new int[] { 1, 1 },
            new int[] { 8, 1 },
            new int[] { 10, 0 },
            new int[] { 5, 0 }
        });
        assert 29 == actual;
    }

    static int luckBalance(int k, int[][] contests) {
        Arrays.sort(contests, (arr1, arr2) -> {
            if (arr1[1] > arr2[1]) {
                return -1;
            } else if (arr1[1] < arr2[1]) {
                return 1;
            } else {
                if (arr1[0] > arr2[0]) {
                    return 1;
                } else if (arr1[0] < arr2[0]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int count = (int) IntStream
            .range(0, contests.length)
            .filter(i -> contests[i][1] > 0)
            .count();
        int res = 0;
        int counter = count - k;
        for (int i = 0; i < contests.length; i++) {
            int delta = counter > 0 ? (-1) : 1;
            res += delta * contests[i][0];
            counter--;
        }
        return res;
    }
}
