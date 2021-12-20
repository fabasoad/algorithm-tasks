package com.fabasoad.leetcode.easy;

public class Solution_9 {

  public static void main(String[] args) {
    assert isPalindrome(121);
    assert !isPalindrome(-121);
    assert !isPalindrome(10);
  }

  public static boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    final String str = String.valueOf(x);
    for (int i = 0; i < str.length() / 2; i++) {
      if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
        return false;
      }
    }
    return true;
  }
}
