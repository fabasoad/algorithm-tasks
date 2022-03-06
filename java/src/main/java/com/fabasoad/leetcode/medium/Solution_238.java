package com.fabasoad.leetcode.medium;

import java.util.Arrays;

public class Solution_238 {

  public int[] productExceptSelf(int[] nums) {
    int[] res = new int[nums.length];
    int found = 0;
    int ind = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        found++;
        ind = i;
      }
      if (found > 1) {
        break;
      }
    }
    if (found > 1) {
      return res;
    }
    int total = 1;
    if (found == 1) {
      for (int i = 0; i < nums.length; i++) {
        if (i != ind) {
          total *= nums[i];
        }
      }
      res[ind] = total;
    } else {
      for (int i = 1; i < nums.length; i++) {
        total *= nums[i];
      }
      res[0] = total;
      for (int i = 1; i < nums.length; i++) {
        total /= nums[i];
        total *= nums[i - 1];
        res[i] = total;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    final Solution_238 s = new Solution_238();
    System.out.println(Arrays.toString(s.productExceptSelf(new int[]{1,2,3,4})));
    System.out.println(Arrays.toString(s.productExceptSelf(new int[]{-1,1,0,-3,3})));
    System.out.println(Arrays.toString(s.productExceptSelf(new int[]{-1,1,0,-3,0})));
  }
}
