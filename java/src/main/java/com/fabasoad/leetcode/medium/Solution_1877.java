package com.fabasoad.leetcode.medium;

import java.util.Arrays;

public class Solution_1877 {

  // Brute Force solution with "Time limit exceeded:
//  int prev = 0;
//
//  private void pair(List<Integer> nums, List<Integer> maximums, List<List<Integer>> total) {
//    for (int i = 1; i < nums.size(); i++) {
//      if (prev != total.size()) {
//        for (int j = 0; j < nums.size() / 2; j++) {
//          maximums.remove(maximums.size() - 1);
//        }
//        prev = total.size();
//      }
//      maximums.add(nums.get(0) + nums.get(i));
//      List<Integer> arr = new ArrayList<>(nums);
//      arr.remove(0);
//      arr.remove(i - 1);
//      if (arr.isEmpty()) {
//        total.add(new ArrayList<>(maximums));
//      } else {
//        pair(arr, maximums, total);
//      }
//    }
//  }
//
//  public int minPairSum(int[] nums) {
//    final List<List<Integer>> total = new ArrayList<>();
//    pair(Arrays.stream(nums).boxed().collect(Collectors.toList()), new ArrayList<>(), total);
//    final int[] f = new int[total.size()];
//    for (int i = 0; i < total.size(); i++) {
//      final List<Integer> maximums = total.get(i);
//      int maxFinal = -1;
//      for (int max : maximums) {
//        if (maxFinal < max) {
//          maxFinal = max;
//          f[i] = maxFinal;
//        }
//      }
//    }
//    int min = Integer.MAX_VALUE;
//    for (int j : f) {
//      if (min > j) {
//        min = j;
//      }
//    }
//    return min;
//  }

  // O(n*log(n)) solution
  public int minPairSum(int[] nums) {
    int max = Integer.MIN_VALUE;
    Arrays.sort(nums);
    int j = nums.length - 1, i = 0, sum;

    while (i <= j) {
      sum = nums[i] + nums[j];
      i++;
      j--;
      if (sum > max) {
        max = sum;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    assert 7 == new Solution_1877().minPairSum(new int[] { 3,5,3,2 });
    assert 8 == new Solution_1877().minPairSum(new int[] { 3,5,4,2,4,6 });
    assert 6 == new Solution_1877().minPairSum(new int[] { 3,2,4,1,1,5,1,3,5,1 });
    assert 14 == new Solution_1877().minPairSum(new int[]{9, 2, 10, 1, 10, 4, 8, 9, 7, 6, 8, 10, 8, 6, 5, 4, 3, 4, 2, 10});
  }
}
