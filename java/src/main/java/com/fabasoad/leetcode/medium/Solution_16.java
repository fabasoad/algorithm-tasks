package com.fabasoad.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution_16 {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    final Set<Integer> res = new HashSet<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int l = i + 1;
      int r = nums.length - 1;
      while (l < r) {
        int s = nums[i] + nums[l] + nums[r];
        if (s < target) {
          l++;
          while (l < r && nums[l] == nums[l - 1]) {
            l++;
          }
        } else if (s > target) {
          r--;
          while (l < r && nums[r] == nums[r + 1]) {
            r--;
          }
        } else {
          return s;
        }
        res.add(s);
      }
    }
    int diff = Integer.MAX_VALUE;
    int orig = 0;
    for (int sum : res) {
      final int abs = Math.abs(sum - target);
      if (abs < diff) {
        diff = abs;
        orig = sum;
      }
    }
    return orig;
  }

  public static void main(String[] args) {
    final Solution_16 s = new Solution_16();
    System.out.println(s.threeSumClosest(new int[] {-1,2,1,-4}, 1)); // 2
    System.out.println(s.threeSumClosest(new int[] {0,0,0}, 1)); // 0
    System.out.println(s.threeSumClosest(new int[] {4,3,-2,1}, 2)); // 2
    System.out.println(s.threeSumClosest(new int[] {1,1,1,0}, -100)); // 2
    System.out.println(s.threeSumClosest(new int[] {1,1,-1,-1,3}, -1)); // -1
    System.out.println(s.threeSumClosest(new int[] {1,2,5,10,11}, 12)); // 13
  }
}