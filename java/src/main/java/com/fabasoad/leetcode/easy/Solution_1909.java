package com.fabasoad.leetcode.easy;

public class Solution_1909 {

  public static void main(String[] args) {
    assert canBeIncreasing(new int[] { 1,2,10,5,7 });
    assert !canBeIncreasing(new int[] { 2,3,1,2 });
    assert !canBeIncreasing(new int[] { 1,1,1 });
    assert canBeIncreasing(new int[] { 105,924,32,968 });
  }

  private static boolean loop(int[] nums, int cache) {
    for (int i = 1; i < nums.length; i++) {
      int prev = cache == i - 1 ? i - 2 : i - 1;
      int curr = cache == i ? i + 1 : i;
      if (prev < 0 || curr == nums.length) {
        continue;
      }
      if (nums[prev] >= nums[curr]) {
        return false;
      }
    }
    return true;
  }

  public static boolean canBeIncreasing(int[] nums) {
    int left = -1;
    int right = -1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] >= nums[i]) {
        left = i - 1;
        right = i;
        break;
      }
    }
    if (right == -1) {
      return true;
    }
    return loop(nums, left) || loop(nums, right);
  }

  public static boolean canBeIncreasing3(int[] nums) {
    byte c = 0;
    for (int i = 1; i < nums.length; i++) {
      int k = 0;
      while ((i - 1 - k) >= 0 && nums[i - 1 - k] >= nums[i]) {
        c++;
        if (c > 1) {
          return false;
        }
        k++;
      }
    }
    return true;
  }
}
