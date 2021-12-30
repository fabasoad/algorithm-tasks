package com.fabasoad.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Solution_169 {

  public static void main(String[] args) {
    assert 3 == majorityElement(new int[] { 3,2,3 });
    assert 2 == majorityElement(new int[] { 2,2,1,1,1,2,2 });
  }

  public static int majorityElement(int[] nums) {
    final Map<Integer, Integer> storage = new HashMap<>();
    int max_n = 0;
    int max_c = 0;
    for (int n : nums) {
      storage.merge(n, 1, Integer::sum);
      if (storage.get(n) > max_c) {
        max_c = storage.get(n);
        max_n = n;
      }
    }
    return max_n;
  }
}
