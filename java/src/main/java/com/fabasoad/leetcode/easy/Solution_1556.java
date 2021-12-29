package com.fabasoad.leetcode.easy;

public class Solution_1556 {

  public static void main(String[] args) {
    assert "987".equals(thousandSeparator(987));
    assert "1.234".equals(thousandSeparator(1234));
    assert "123.456.789".equals(thousandSeparator(123456789));
    assert "2.147.483.647".equals(thousandSeparator(Integer.MAX_VALUE));
    assert "0".equals(thousandSeparator(0));
    assert "1".equals(thousandSeparator(1));
    assert "51.040".equals(thousandSeparator(51040));
  }

  public static String thousandSeparator(int n) {
    final String str = String.valueOf(n);
    final StringBuilder sb = new StringBuilder();
    for (int i = str.length(); i > 0; i -= 3) {
      int from = i - 3;
      sb.insert(0, str, Math.max(from, 0), i);
      if (from > 0) {
        sb.insert(0, ".");
      }
    }
    return sb.toString();
  }
}
