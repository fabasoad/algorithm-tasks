package io.github.fabasoad.hackerrank.easy;

import java.util.stream.LongStream;

/**
 * https://www.hackerrank.com/challenges/mini-max-sum/problem
 */
public class Solution_MiniMaxSum {

    private static void sum(long... a) {
        System.out.println(LongStream.of(a).sum());
    }

    public static void main(String[] args) {
        sum(627450398, 954173620, 583762094, 236817490);
        sum(942381765, 954173620, 583762094, 236817490);
        sum(942381765, 627450398, 583762094, 236817490);
        sum(942381765, 627450398, 954173620, 236817490);
        sum(942381765, 627450398, 954173620, 583762094);
        miniMaxSum(new int[] { 942381765, 627450398, 954173620, 583762094, 236817490 });
    }

    static void miniMaxSum(int[] arr) {
        long[] sums = new long[arr.length];
        int index = 0;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        while (index < sums.length) {
            for (int i = 0; i < arr.length; i++) {
                if (i == index) {
                    continue;
                }
                sums[index] += arr[i];
            }
            if (sums[index] > max) {
                max = sums[index];
            }
            if (sums[index] < min) {
                min = sums[index];
            }
            index++;
        }
        System.out.println(min + " " + max);
    }
}
