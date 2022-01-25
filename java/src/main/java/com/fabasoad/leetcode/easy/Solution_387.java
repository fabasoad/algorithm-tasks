package com.fabasoad.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Solution_387 {

  public int firstUniqChar(String s) {
    final Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.merge(s.charAt(i), 1, Integer::sum);
    }
    for (int i = 0; i < s.length(); i++) {
      if (map.get(s.charAt(i)) == 1) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    final Solution_387 s = new Solution_387();
    assert 0 == s.firstUniqChar("leetcode");
    assert 2 == s.firstUniqChar("loveleetcode");
    assert -1 == s.firstUniqChar("aabb");
  }
}
