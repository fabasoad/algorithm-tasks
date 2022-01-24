package com.fabasoad.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution_349 {

  public int[] intersection(int[] nums1, int[] nums2) {
    int[] left;
    int[] right;
    if (nums1.length > nums2.length) {
      left = nums1;
      right = nums2;
    } else {
      left = nums2;
      right = nums1;
    }
    final Map<Integer, Integer> map = new HashMap<>();
    for (int n : left) {
      map.merge(n, 1, Integer::sum);
    }
    final Set<Integer> res = new HashSet<>();
    for (int n : right) {
      if (map.containsKey(n) && map.get(n) > 0) {
        res.add(n);
      }
    }
    return res.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    final Solution_349 s = new Solution_349();
    System.out.println(Arrays.toString(s.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    System.out.println(Arrays.toString(s.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
  }
}
