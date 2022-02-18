package com.fabasoad.leetcode.easy;

import java.util.Arrays;

public class Solution_2022 {

  public int[][] construct2DArray(int[] original, int m, int n) {
    if (original.length != m * n) {
      return new int[0][];
    }
    final int[][] result = new int[m][n];
    int row = 0;
    int i = 0;
    while (row < m) {
      int column = 0;
      while (column < n) {
        result[row][column] = original[i];
        i++;
        column++;
      }
      row++;
    }
    return result;
  }

  public static void main(String[] args) {
    final Solution_2022 s = new Solution_2022();
    System.out.println(Arrays.deepToString(s.construct2DArray(new int[]{1, 2, 3, 4}, 2, 2)));
    System.out.println(Arrays.deepToString(s.construct2DArray(new int[]{1, 2, 3}, 1, 3)));
    System.out.println(Arrays.deepToString(s.construct2DArray(new int[]{1, 2}, 1, 1)));
  }
}
