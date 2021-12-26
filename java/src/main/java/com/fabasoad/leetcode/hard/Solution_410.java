package com.fabasoad.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class Solution_410 {

  // TODO: Solve it
  public static void main(String[] args) {
    assert 18 == splitArray(new int[] { 7,2,5,10,8 }, 2);
    assert 9 == splitArray(new int[] { 1,2,3,4,5 }, 2);
    assert 4 == splitArray(new int[] { 1,4,4 }, 3);
    assert 5 == splitArray(new int[] { 1,4,4,5 }, 3); // [1,4,9] [5,4,5] [1,8,5]
  }

  public static int splitArray(int[] nums, int m) {
    final List<Integer> sums = new ArrayList<>();
    run(nums, 0, nums.length, 1, m, sums);
    return 0;
  }

  private static void run(int[] nums, int from, int to, int c, int m, List<Integer> sums) {

  }

  private static int sum(int[] nums, int from, int to) {
    int result = 0;
    for (int i = from; i < to; i++) {
      result += nums[i];
    }
    return result;
  }
}
