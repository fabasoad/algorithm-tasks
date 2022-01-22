package com.fabasoad.leetcode.easy;

public class Solution_1752 {

  public static void main(String[] args) {
    assert check(new int[] {3,4,5,1,2});
    assert !check(new int[] {2,1,3,4});
  }

  public static boolean check(int[] nums) {
    int ind = -1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > nums[i]) {
        ind = i;
      }
    }
    if (ind == -1) {
      return true;
    }
    int[] res = new int[nums.length];
    int x = 0;
    for (int i = ind; i < nums.length; i++) {
      res[x] = nums[i];
      x++;
    }
    for (int i = 0; i < ind; i++) {
      res[x] = nums[i];
      x++;
    }
    for (int i = 1; i < res.length; i++) {
      if (res[i - 1] > res[i]) {
        return false;
      }
    }
    return true;
  }
}
