package com.fabasoad.leetcode.easy;

public class Solution_344 {

  public static void main(String[] args) {
    final char[] c1 = {'h', 'e', 'l', 'l', 'o'};
    reverseString(c1);
    System.out.println(c1);
    final char[] c2 = {'d', 'e', 's', 'k'};
    reverseString(c2);
    System.out.println(c2);
  }

  public static void reverseString(char[] s) {
    for (int i = 0; i < s.length / 2; i++) {
      char c = s[i];
      s[i] = s[s.length - 1 - i];
      s[s.length - 1 - i] = c;
    }
  }
}
