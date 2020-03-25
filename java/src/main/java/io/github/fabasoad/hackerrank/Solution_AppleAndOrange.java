package io.github.fabasoad.hackerrank;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/apple-and-orange/problem
 */
public class Solution_AppleAndOrange {

    public static void main(String[] args) {
        countApplesAndOranges(7, 11, 5, 15, new int[] { -2, 2, 1 }, new int[] { 5, -6 });
    }

    private static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        System.out.println(Arrays.stream(apples).map(x -> a + x).filter(x -> x >= s && x <= t).count());
        System.out.println(Arrays.stream(oranges).map(x -> b + x).filter(x -> x >= s && x <= t).count());
    }
}
