package com.fabasoad.leetcode.medium;

public class Solution_11 {

  // Memory Limit Exceeded
//  public int maxArea(int[] height, int a, int b, int[][] table) {
//    if (table[a][b] > 0) {
//      return table[a][b];
//    }
//    int max1 = (b - a) * Math.min(height[a], height[b]);
//    int max2 = 0;
//    if (b - a > 1) {
//      max2 = Math.max(maxArea(height, a + 1, b, table), maxArea(height, a, b - 1, table));
//    }
//    table[a][b] = Math.max(max1, max2);
//    return table[a][b];
//  }
//
//  public int maxArea(int[] height) {
//    return maxArea(height, 0, height.length - 1, new int[height.length][height.length]);
//  }

  // Time Limit Exceeded
//  public int maxArea(int[] height) {
//    int max = 0;
//    for (int i = 0; i < height.length; i++) {
//      for (int j = height.length - 1; j > i; j--) {
//        max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
//      }
//    }
//    return max;
//  }

  public int maxArea(int[] height) {
    int i = 0;
    int j = height.length - 1;
    int max = 0;
    while (i < j) {
      max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
      if (height[i] > height[j]) {
        j--;
      } else {
        i++;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    final Solution_11 s = new Solution_11();
    System.out.println(s.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    System.out.println(s.maxArea(new int[] {1,1}));
  }
}
