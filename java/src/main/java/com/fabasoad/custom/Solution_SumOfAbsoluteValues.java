package com.fabasoad.custom;

import java.util.Arrays;

public class Solution_SumOfAbsoluteValues {

  long[] calc(int[] seq, int[][] pairs) {
    long[] res = new long[pairs.length];
    for (int i = 0; i < pairs.length; i++) {
      for (int j = pairs[i][0] - 1; j < pairs[i][1]; j++) {
        res[i] += Math.abs(seq[j]);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    final Solution_SumOfAbsoluteValues s = new Solution_SumOfAbsoluteValues();
    System.out.println(Arrays.toString(s.calc(new int[]{1, -2, 3, -4, 5, 6}, new int[][]{{1, 2}, {2, 4}, {3, 6}})));
    System.out.println(Arrays.toString(s.calc(new int[]{1, -2, Integer.MAX_VALUE, -4, 5, 6}, new int[][]{{1, 2}, {2, 4}, {3, 6}})));
  }
}
