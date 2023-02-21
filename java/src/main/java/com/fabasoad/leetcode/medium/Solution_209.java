package com.fabasoad.leetcode.medium;

public class Solution_209 {
  public int minSubArrayLen(int target, int[] nums) {
    int left = 0;
    int right = left;
    int sum = 0;
    int min = Integer.MAX_VALUE;
    while (left < nums.length) {
      while (right <= nums.length) {
        if (sum >= target) {
          min = Math.min(min, right - left);
          break;
        }
        if (right == nums.length) {
          break;
        }
        sum += nums[right];
        right++;
      }
      sum -= nums[left];
      left++;
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }

  public static void main(String[] args) {
    final var s = new Solution_209();
    assert 2 == s.minSubArrayLen(7, new int[] {2,3,1,2,4,3});
    assert 1 == s.minSubArrayLen(4, new int[] {1,4,4});
    assert 0 == s.minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1});
    assert 0 == s.minSubArrayLen(1, new int[0]);
  }
}
