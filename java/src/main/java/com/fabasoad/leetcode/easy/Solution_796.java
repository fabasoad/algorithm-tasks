package com.fabasoad.leetcode.easy;

public class Solution_796 {

  public static void main(String[] args) {
    assert rotateString("abcde", "cdeab");
    assert !rotateString("abcde", "abced");
  }

  public static boolean rotateString(String s, String goal) {
    final int expected = goal.hashCode();
    int i = 0;
    while (i < s.length()) {
      final int actual = s.hashCode();
      if (actual == expected) {
        return true;
      }
      s = s.substring(1) + s.charAt(0);
      i++;
    }
    return false;
  }
}
