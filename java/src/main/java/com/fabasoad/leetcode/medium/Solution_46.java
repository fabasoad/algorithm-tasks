package com.fabasoad.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_46 {

  private static void permute(int[] nums, Set<Integer> skip, List<Integer> list, List<List<Integer>> total) {
    if (skip.size() == nums.length) {
      total.add(list);
    }
    for (int i = 0; i < nums.length; i++) {
      if (!skip.contains(i)) {
        skip.add(i);
        list.add(nums[i]);
        permute(nums, new HashSet<>(skip), new ArrayList<>(list), total);
      }
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    final List<List<Integer>> total = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      final Set<Integer> skip = new HashSet<>();
      skip.add(i);
      final ArrayList<Integer> list = new ArrayList<>();
      list.add(nums[i]);
      permute(nums, skip, list, total);
    }
    return total;
  }

  public static void main(String[] args) {
    final Solution_46 s = new Solution_46();
    System.out.println(s.permute(new int[] { 1,2,3 }));
    System.out.println(s.permute(new int[] { 0,1 }));
    System.out.println(s.permute(new int[] { 1 }));
  }
}
