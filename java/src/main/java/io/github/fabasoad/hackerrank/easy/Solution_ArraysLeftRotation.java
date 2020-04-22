package io.github.fabasoad.hackerrank.easy;

/**
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
 */
public class Solution_ArraysLeftRotation {

    static int[] rotLeft(int[] a, int d) {
        int[] res = new int[a.length];
        int index = 0;
        for (int i = d; index < a.length; i = (i + 1) % a.length) {
            res[index] = a[i];
            index++;
        }
        return res;
    }
}
