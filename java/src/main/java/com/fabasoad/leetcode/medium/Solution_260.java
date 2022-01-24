package com.fabasoad.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_260 {

  public static void main(String[] args) {
    final Solution_260 s = new Solution_260();
    System.out.println(Arrays.toString(s.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    System.out.println(Arrays.toString(s.singleNumber(new int[]{-1, 0})));
    System.out.println(Arrays.toString(s.singleNumber(new int[]{0, 1})));
  }

  public int[] singleNumber(int[] nums) {
    final Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.merge(num, 1, Integer::sum);
    }
    int x = 0;
    int[] res = new int[2];
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        res[x] = entry.getKey();
        x++;
      }
    }
    return res;
  }
}
