package com.fabasoad.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution_1877 {

  static int prev = 0;

  private static void pair(int[] nums, List<int[]> list, List<List<int[]>> total) {
    for (int i = 1; i < nums.length; i++) {
      if (prev != total.size()) {
        for (int j = 0; j < nums.length / 2; j++) {
          list.remove(list.size() - 1);
        }
        prev = total.size();
      }
      list.add(new int[] { nums[0], nums[i] });
      int[] arr = new int[nums.length - 2];
      int x = 0;
      for (int j = 1; j < nums.length; j++) {
        if (j != i) {
          arr[x] = nums[j];
          x++;
        }
      }
      if (arr.length == 0) {
        total.add(new ArrayList<>(list));
      } else {
        pair(arr, list, total);
      }
    }
  }

  public static int minPairSum(int[] nums) {
    final List<List<int[]>> total = new ArrayList<>();
    pair(nums, new ArrayList<>(), total);
    return 0;
  }

  public static void main(String[] args) {
//    assert 7 == minPairSum(new int[] { 3,5,3,2 });
//    assert 8 == minPairSum(new int[] { 3,5,4,2,4,6 });
    assert 6 == minPairSum(new int[] { 3,2,4,1,1,5,1,3,5,1 });
  }
}
