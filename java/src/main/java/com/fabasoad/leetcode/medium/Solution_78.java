package com.fabasoad.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_78 {

  public static void main(String[] args) {
    subsets(new int[] { 1,2,3 });
    subsets(new int[] { 0 });
  }

  private static void subset(int[] nums, int from, List<Integer> subList, List<List<Integer>> list) {
    subList.add(nums[from]);
    for (int i = from + 1; i < nums.length; i++) {
      subset(nums, i, new ArrayList<>(subList), list);
    }
    list.add(subList);
  }

  public static List<List<Integer>> subsets(int[] nums) {
    final List<List<Integer>> list = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      subset(nums, i, new ArrayList<>(), list);
    }
    list.add(Collections.emptyList());
    return list;
  }
}
