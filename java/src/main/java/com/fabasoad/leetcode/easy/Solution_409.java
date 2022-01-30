package com.fabasoad.leetcode.easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution_409 {

  public int longestPalindrome(String s) {
    final Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.merge(s.charAt(i), 1, Integer::sum);
    }
    int sum = 0;
    boolean found = false;
    for (Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
      final Map.Entry<Character, Integer> entry = it.next();
      final Integer val = entry.getValue();
      if (val >= 2) {
        int delta = val % 2;
        sum += (delta == 1 ? val - delta : val);
        if (delta == 1) {
          map.put(entry.getKey(), delta);
        } else {
          it.remove();
        }
      } else if (val == 1) {
        if (!found) {
          sum++;
          found = true;
        }
        it.remove();
      }
    }
    return sum + (map.isEmpty() || found ? 0 : 1);
  }

  public static void main(String[] args) {
    final Solution_409 s = new Solution_409();
    assert 7 == s.longestPalindrome("abccccdd");
    assert 1 == s.longestPalindrome("a");
    assert 2 == s.longestPalindrome("bb");
    assert 3 == s.longestPalindrome("ccc");
    assert 5 == s.longestPalindrome("bananas");
  }
}
