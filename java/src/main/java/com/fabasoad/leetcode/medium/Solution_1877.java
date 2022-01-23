package com.fabasoad.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_1877 {

  int prev = 0;

  private void pair(List<Integer> nums, List<int[]> list, List<List<int[]>> total) {
    for (int i = 1; i < nums.size(); i++) {
      if (prev != total.size()) {
        for (int j = 0; j < nums.size() / 2; j++) {
          list.remove(list.size() - 1);
        }
        prev = total.size();
      }
      list.add(new int[] { nums.get(0), nums.get(i), nums.get(0) + nums.get(i) });
      List<Integer> arr = new ArrayList<>(nums);
      arr.remove(0);
      arr.remove(i - 1);
      if (arr.isEmpty()) {
        total.add(new ArrayList<>(list));
      } else {
        pair(arr, list, total);
      }
    }
  }

  public int minPairSum(int[] nums) {
    final List<List<int[]>> total = new ArrayList<>();
    pair(Arrays.stream(nums).boxed().collect(Collectors.toList()), new ArrayList<>(), total);
    final int[] f = new int[total.size()];
    for (int i = 0; i < total.size(); i++) {
      final List<int[]> a = total.get(i);
      int max = -1;
      for (int[] b : a) {
        final int sum = b[2];
        if (max < sum) {
          max = sum;
          f[i] = max;
        }
      }
    }
    int min = Integer.MAX_VALUE;
    for (int j : f) {
      if (min > j) {
        min = j;
      }
    }
    return min;
  }

  public static void main(String[] args) {
    assert 7 == new Solution_1877().minPairSum(new int[] { 3,5,3,2 });
    assert 8 == new Solution_1877().minPairSum(new int[] { 3,5,4,2,4,6 });
    assert 6 == new Solution_1877().minPairSum(new int[] { 3,2,4,1,1,5,1,3,5,1 });
  }
}
