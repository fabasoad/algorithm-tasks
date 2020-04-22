package io.github.fabasoad.hackerrank.easy;

/**
 * https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
 */
public class Solution_DivisibleSumPairs {

    public static void main(String[] args) {
        System.out.println(divisibleSumPairs(6, 3, new int[] { 1, 3, 2, 6, 1, 2 }));
    }

    private static int divisibleSumPairs(int n, int k, int[] ar) {
        int counter = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((ar[i] + ar[j]) % k == 0) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
