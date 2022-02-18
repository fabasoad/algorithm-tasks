package com.fabasoad.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class Solution_2154 {

  private final Set<Integer> set = new HashSet<>();

  public int findFinalValue(int[] nums, int original) {
    if (set.isEmpty()) {
      for (int num : nums) {
        set.add(num);
      }
    }
    if (set.contains(original)) {
      return findFinalValue(nums, original * 2);
    }
    return original;
  }

  public static void main(String[] args) {
    final Solution_2154 s = new Solution_2154();
    assert 24 == s.findFinalValue(new int[] { 5,3,6,1,12 }, 3);
    assert 4 == s.findFinalValue(new int[] { 2,7,9 }, 4);
  }
}
