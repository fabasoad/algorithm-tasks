package com.fabasoad.leetcode.medium;

import java.util.Arrays;

public class Solution_2149 {

  public int[] rearrangeArray(int[] nums) {
    int pos_ind = 0;
    int neg_ind = 0;
    int[] res = new int[nums.length];
    int res_ind = 0;
    while (res_ind < nums.length) {
      while (pos_ind < nums.length && nums[pos_ind] < 0) {
        pos_ind++;
      }
      while (neg_ind < nums.length && nums[neg_ind] > 0) {
        neg_ind++;
      }
      int curr_ind;
      if (res_ind % 2 == 1) {
        curr_ind = neg_ind;
        neg_ind++;
      } else {
        curr_ind = pos_ind;
        pos_ind++;
      }
      res[res_ind++] = nums[curr_ind];
    }
    return res;
  }

  public static void main(String[] args) {
    final Solution_2149 s = new Solution_2149();
    System.out.println(Arrays.toString(s.rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})));
    System.out.println(Arrays.toString(s.rearrangeArray(new int[]{-1,1})));
  }
}
