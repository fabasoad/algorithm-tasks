package com.fabasoad.leetcode.medium;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Solution_3 {

  public int lengthOfLongestSubstring(String s) {
    final Set<Character> set = new HashSet<>();
    final Queue<Character> queue = new ArrayDeque<>();
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < s.length(); i++) {
      final char c = s.charAt(i);
      if (set.contains(c)) {
        max = Math.max(max, set.size());
        Character c2 = queue.poll();
        set.remove(c2);
        while (c2 != c) {
          c2 = queue.poll();
          set.remove(c2);
        }
      }
      set.add(c);
      queue.add(c);
    }
    return Math.max(max, set.size());
  }

  public static void main(String[] args) {
    final Solution_3 s = new Solution_3();
    assert 3 == s.lengthOfLongestSubstring("abcabcbb");
    assert 1 == s.lengthOfLongestSubstring("bbbbb");
    assert 3 == s.lengthOfLongestSubstring("pwwkew");
    assert 3 == s.lengthOfLongestSubstring("dvdf");
  }
}
