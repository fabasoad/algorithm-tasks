package com.fabasoad.leetcode.easy;

public class Solution_2006 {

  public static void main(String[] args) {
    assert 4 == countKDifference(new int[] { 1,2,2,1 }, 1);
    assert 0 == countKDifference(new int[] { 1,3 }, 3);
    assert 3 == countKDifference(new int[] { 3,2,1,5,4 }, 2);
  }

  public static int countKDifference(int[] nums, int k) {
    int num = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i; j < nums.length; j++) {
        final int diff = Math.abs(nums[i] - nums[j]);
        if (diff == k) {
          num++;
        }
      }
    }
    return num;
  }
}
