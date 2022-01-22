package com.fabasoad.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class Solution_217 {

  public boolean containsDuplicate(int[] nums) {
    Set<Integer> s = new HashSet<>();
    for (int n : nums) {
      s.add(n);
    }
    return s.size() != nums.length;
  }
}
