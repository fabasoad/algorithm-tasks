package com.fabasoad.leetcode.medium;

public class Solution_7 {

  public static void main(String[] args) {
    assert 321 == reverse(123);
    assert -321 == reverse(-123);
    assert 21 == reverse(120);
    assert 0 == reverse(Integer.MAX_VALUE);
    assert 0 == reverse(0);
    assert -2143847412 == reverse(-2147483412);
    assert 0 == reverse(-2147483648);
  }

  private static boolean isValid(String s, boolean positive) {
    final String m = positive
        ? String.valueOf(Integer.MAX_VALUE)
        : String.valueOf(Integer.MIN_VALUE).substring(1);
    if (s.length() > m.length()) {
      return false;
    }
    if (s.length() == m.length()) {
      for (int i = 0; i < s.length(); i++) {
        final int d1 = Integer.parseInt(s, i, i + 1, 10);
        final int d2 = Integer.parseInt(m, i, i + 1, 10);
        if (d1 < d2) {
          break;
        } else if (d1 > d2) {
          return false;
        }
      }
    }
    return true;
  }

  public static int reverse(int x) {
    if (x == 0 || x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
      return 0;
    }
    final String s = String.valueOf(Math.abs(x));
    int[] res = new int[s.length()];
    for (int i = s.length() - 1; i >= 0; i--) {
      res[s.length() - i - 1] = Integer.parseInt(s, i, i + 1, 10);
    }
    int nonZeroIndex = -1;
    for (int i = 0; i < res.length; i++) {
      if (res[i] != 0) {
        nonZeroIndex = i;
        break;
      }
    }
    final StringBuilder result = new StringBuilder();
    for (int i = nonZeroIndex; i < res.length; i++) {
      result.append(res[i]);
    }
    final String resStr = result.toString();
    return isValid(resStr, x > 0) ? Integer.parseInt(resStr) * (x > 0 ? 1 : -1) : 0;
  }
}
