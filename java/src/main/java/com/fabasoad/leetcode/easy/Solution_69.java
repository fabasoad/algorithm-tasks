package com.fabasoad.leetcode.easy;

public class Solution_69 {
  public static void main(String[] args) {
    assert 2 == mySqrt(4);
    assert 2 == mySqrt(8);
    assert 1 == mySqrt(1);
    assert 0 == mySqrt(0);
    assert 3 == mySqrt(9);
    assert 46340 == mySqrt(2147483647);
  }

  public static int mySqrt(int x) {
    if (x == 0) {
      return 0;
    }
    if (x < 4) {
      return 1;
    }
    int min = 2;
    int max = 46340;
    int i = min;
    for (; i <= max; i++) {
      if (i * i > x) {
        return i - 1;
      }
    }
    if (i == max + 1) {
      return max;
    }
    return 0;
  }
}
