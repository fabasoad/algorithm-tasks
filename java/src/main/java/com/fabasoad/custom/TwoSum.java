package com.fabasoad.custom;

import java.util.HashMap;
import java.util.Map;

class TwoSum {

  public static int[] twoSum(int[] nums, int target) {
    final Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.putIfAbsent(target - nums[i], i);
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      if (map.containsKey(nums[i]) && map.get(nums[i]) < i) {
        return new int[] { map.get(nums[i]), i };
      }
    }
    return new int[0];
  }

  public static int[] twoSumSorted(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    while (l < r) {
      int sum = nums[l] + nums[r];
      if (sum == target) {
        return new int[] {l + 1, r + 1};
      } else if (sum < target) {
        l++;
      } else {
        r--;
      }
    }
    return new int[0];
  }

  public static void main(String[] args) {
    int[] actual = twoSum(new int[] {2,7,11,15}, 9);
    assert 2 == actual.length;
    assert 0 == actual[0];
    assert 1 == actual[1];
    actual = twoSum(new int[] {3,2,4}, 6);
    assert 2 == actual.length;
    assert 1 == actual[0];
    assert 2 == actual[1];
    actual = twoSum(new int[] {3,3}, 6);
    assert 2 == actual.length;
    assert 0 == actual[0];
    assert 1 == actual[1];
    actual = twoSum(new int[] {2,4,11,3}, 6);
    assert 2 == actual.length;
    assert 0 == actual[0];
    assert 1 == actual[1];
  }
}
