package com.fabasoad.leetcode.medium;

import java.util.Arrays;

public class Solution_34 {

  private int binarySearch(int[] arr, int l, int r, int x) {
    if (r >= l) {
      int mid = l + (r - l) / 2;
      if (arr[mid] == x) return mid;
      if (arr[mid] > x) return binarySearch(arr, l, mid - 1, x);
      return binarySearch(arr, mid + 1, r, x);
    }
    return -1;
  }

  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[] {-1,-1};
    if (nums.length == 0) {
      return res;
    }
    final int ind = binarySearch(nums, 0, nums.length - 1, target);
    if (ind != -1) {
      int left = ind;
      do {
        res[0] = left;
        left--;
      } while (left > -1 && nums[left] == target);
      int right = ind;
      do {
        res[1] = right;
        right++;
      } while (right < nums.length && nums[right] == target);
    }
    return res;
  }

  public static void main(String[] args) {
    final Solution_34 s = new Solution_34();
    System.out.println(Arrays.toString(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    System.out.println(Arrays.toString(s.searchRange(new int[]{5,7,7,8,8,10}, 6)));
    System.out.println(Arrays.toString(s.searchRange(new int[0], 0)));
    System.out.println(Arrays.toString(s.searchRange(new int[] {1}, 0)));
    System.out.println(Arrays.toString(s.searchRange(new int[] {1}, 1)));
    System.out.println(Arrays.toString(s.searchRange(new int[] {1,3}, 1)));
  }
}
