package com.fabasoad.leetcode.easy;

public class Solution_125 {
  private final int R_1 = 48; // 0
  private final int R_2 = 57; // 9
  private final int R_3 = 65; // A
  private final int R_4 = 90; // Z
  private final int R_5 = 97; // a
  private final int R_6 = 122; // z

  private boolean isDigit(int c) {
    return c >= R_1 && c <= R_2;
  }

  private boolean isUpper(int c) {
    return c >= R_3 && c <= R_4;
  }

  private boolean isLower(int c) {
    return c >= R_5 && c <= R_6;
  }

  private boolean inRange(int c) {
    // ----48***57---65**90---97**122---
    return isLower(c) || isUpper(c) || isDigit(c);
  }
  
  public boolean isPalindrome(String s) {
    final var DELTA = 32; // a - A
    int l = 0;
    int r = s.length() - 1;
    while (l < r) {
      final int left = s.codePointAt(l);
      if (!inRange(left)) {
        l++;
        continue;
      }
      final int right = s.codePointAt(r);
      if (!inRange(right)) {
        r--;
        continue;
      }
      var a = true;
      if (isUpper(left) && isLower(right)) {
        a = left != right - DELTA;
      }
      if (isLower(left) && isUpper(right)) {
        a = left != right + DELTA;
      }
      if ((isLower(left) && isLower(right))
          || (isUpper(left) && isUpper(right))
          || (isDigit(left) && isDigit(right))) {
        a = left != right;
      }
      if (a) {
        return false;
      }
      l++;
      r--;
    }
    return true;
  }

  public static void main(String[] args) {
    final var s = new Solution_125();
    assert s.isPalindrome("A man, a plan, a canal: Panama");
    assert !s.isPalindrome("race a car");
    assert !s.isPalindrome("0P");
    assert s.isPalindrome(" ");
    assert s.isPalindrome("a.");
    assert s.isPalindrome("1b1");
    assert !s.isPalindrome("ab2a");
  }
}
