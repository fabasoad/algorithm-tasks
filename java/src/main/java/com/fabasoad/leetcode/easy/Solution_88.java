package com.fabasoad.leetcode.easy;

public class Solution_88 {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] res = new int[n + m];
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < m && j < n) {
      if (nums1[i] < nums2[j]) {
        res[k] = nums1[i];
        i++;
      } else {
        res[k] = nums2[j];
        j++;
      }
      k++;
    }
    while (i < m) {
      res[k] = nums1[i];
      i++;
      k++;
    }
    while (j < n) {
      res[k] = nums2[j];
      j++;
      k++;
    }
    System.arraycopy(res, 0, nums1, 0, res.length);
  }
}
