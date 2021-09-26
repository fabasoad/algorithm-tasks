package com.fabasoad.leetcode.easy;

/**
 * https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class Solution_RunningSum {

  public static void main(String[] args) {
    assertArrays(new int[] { 1, 2, 3, 4 }, new int[] { 1, 3, 6, 10 });
    assertArrays(new int[] { 1, 1, 1, 1, 1 }, new int[] { 1, 2, 3, 4, 5 });
    assertArrays(new int[] { 3, 1, 2, 10, 1 }, new int[] { 3, 4, 6, 16, 17 });
  }

  private static void assertArrays(int[] input, int[] expected) {
    int[] actual = runningSum(input);
    assert assertArrayEquals(expected, actual);
  }

  private static boolean assertArrayEquals(int[] a, int[] b) {
    if (a.length != b.length) {
      return false;
    }
    for (int i = 0; i < a.length; i++) {
      if (a[i] != b[i]) {
        return false;
      }
    }
    return true;
  }

  private static int[] runningSum(final int[] nums) {
    if (nums.length == 0) {
      return nums;
    }
    for (int i = 1; i < nums.length; i++) {
      nums[i] = nums[i] + nums[i - 1];
    }
    return nums;
  }
}
