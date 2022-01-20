package com.fabasoad.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Solution_389 {

  public static void main(String[] args) {
    assert 'e' == findTheDifference("abcd", "abcde");
    assert 'y' == findTheDifference("", "y");
  }

  public static char findTheDifference(String s, String t) {
    final Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.merge(s.charAt(i), 1, Integer::sum);
    }
    for (int i = 0; i < t.length(); i++) {
      final char c = t.charAt(i);
      if (!map.containsKey(c) || map.get(c) == 0) {
        return c;
      }
      map.merge(c, -1, Integer::sum);
    }
    return 'a';
  }
}
