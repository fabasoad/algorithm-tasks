package com.fabasoad.leetcode.easy;

public class Solution_1748 {

  public int sumOfUnique(int[] nums) {
    int[] arr = new int[100];
    for (int n : nums) {
      arr[n - 1] += 1;
    }
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 1) {
        sum += (i + 1);
      }
    }
    return sum;
  }
}
