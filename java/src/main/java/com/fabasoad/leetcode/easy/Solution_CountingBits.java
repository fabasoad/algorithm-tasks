package com.fabasoad.leetcode.easy;

import java.util.Arrays;

public class Solution_CountingBits {

  public static void main(String[] args) {
    assert Arrays.equals(new int[]{0,1,1}, countBits(2));
    assert Arrays.equals(new int[]{0,1,1,2,1,2}, countBits(5));
  }

  public static int[] countBits(int n) {
    final var result = new int[n + 1];
    result[0] = 0;
    for (int i = 1; i <= n; i++) {
      result[i] = (int) Arrays.stream(Integer.toString(i, 2).split("")).filter(x -> !x.equals("0")).count();
    }
    return result;
  }
}
