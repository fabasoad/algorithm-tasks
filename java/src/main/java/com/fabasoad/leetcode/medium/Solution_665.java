package com.fabasoad.leetcode.medium;

// Very similar to 1909. Differences in the comments below (>= instead of >).
class Solution_665 {

  private boolean loop(int[] nums, int cache) {
    for (int i = 1; i < nums.length; i++) {
      int prev = cache == i - 1 ? i - 2 : i - 1;
      int curr = cache == i ? i + 1 : i;
      if (prev < 0 || curr == nums.length) {
        continue;
      }
      if (nums[prev] /* >= */ > nums[curr]) {
        return false;
      }
    }
    return true;
  }

  public boolean checkPossibility(int[] nums) {
    int left = -1;
    int right = -1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] /* >= */ > nums[i]) {
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
}
