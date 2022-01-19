package com.fabasoad.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_398 {

  static class Solution {

    private final Map<Integer, List<Integer>> nums = new HashMap<>();
    private final Map<Integer, Integer> currIndex = new HashMap<>();

    public Solution(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        if (!this.nums.containsKey(nums[i])) {
          this.nums.put(nums[i], new ArrayList<>());
        }
        this.nums.get(nums[i]).add(i);
        currIndex.putIfAbsent(nums[i], 0);
      }
    }

    public int pick(int target) {
      final Integer ind = currIndex.get(target);
      if (ind + 1 == nums.get(target).size()) {
        currIndex.put(target, 0);
      } else {
        currIndex.merge(target, 1, Integer::sum);
      }
      return nums.get(target).get(ind);
    }
  }

  public static void main(String[] args) {
    final Solution solution = new Solution(new int[]{1, 2, 3, 3, 3});
    System.out.println(solution.pick(3));
    System.out.println(solution.pick(1));
    System.out.println(solution.pick(1));
    System.out.println(solution.pick(3));
    System.out.println(solution.pick(3));
    System.out.println(solution.pick(3));
  }
}
