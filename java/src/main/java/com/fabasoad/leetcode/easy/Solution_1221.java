package com.fabasoad.leetcode.easy;

public class Solution_1221 {

  private static final char L = 'L';

  public int balancedStringSplit(String s) {
    int res = 0;
    int pairs = 0;
    for (int i = 0; i < s.length(); i++) {
      res += s.charAt(i) == L ? -1 : 1;
      if (res == 0) {
        pairs++;
      }
    }
    return pairs;
  }

  public static void main(String[] args) {
    final Solution_1221 s = new Solution_1221();
    assert 4 == s.balancedStringSplit("RLRRLLRLRL");
    assert 3 == s.balancedStringSplit("RLLLLRRRLR");
    assert 1 == s.balancedStringSplit("LLLLRRRR");
  }
}
