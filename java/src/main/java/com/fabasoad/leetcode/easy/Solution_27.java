package com.fabasoad.leetcode.easy;

public class Solution_27 {

  public static void main(String[] args) {
    assert 2 == removeElement(new int[] { 3,2,2,3 }, 3);
    assert 5 == removeElement(new int[] { 0,1,2,2,3,0,4,2 }, 2);
  }

  private static int findIndex(int[] nums, int start, int val) {
    for (int i = start; i < nums.length; i++) {
      if (nums[i] != val) {
        return i;
      }
    }
    return -1;
  }

  private static void swap(int[] nums, int a, int b) {
    int x = nums[a];
    nums[a] = nums[b];
    nums[b] = x;
  }

  public static int removeElement(int[] nums, int val) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == val) {
        final int j = findIndex(nums, i + 1, val);
        if (j == -1) {
          return i;
        }
        swap(nums, i, j);
      }
    }
    return nums.length;
  }
}
