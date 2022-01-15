package com.fabasoad.leetcode.easy;

public class Solution_2011 {

  private static final String PLUS_1 = "++X";
  private static final String PLUS_2 = "X++";

  public int finalValueAfterOperations(String[] operations) {
    int x = 0;
    for (final String op : operations) {
      if (PLUS_1.equals(op) || PLUS_2.equals(op)) {
        x++;
      } else {
        x--;
      }
    }
    return x;
  }
}
