package com.fabasoad.leetcode.easy;

public class Solution_1108 {

  private final static char DOT = '.';
  private final static String DOT_STR = "[.]";

  public static void main(String[] args) {
    assert "1[.]1[.]1[.]1".equals(defangIPaddr("1.1.1.1"));
    assert "255[.]100[.]50[.]0".equals(defangIPaddr("255.100.50.0"));
  }

  public static String defangIPaddr(String address) {
    final StringBuilder sb = new StringBuilder();
    for (char c : address.toCharArray()) {
      if (c == DOT) {
        sb.append(DOT_STR);
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}
