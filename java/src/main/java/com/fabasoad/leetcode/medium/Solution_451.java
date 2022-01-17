package com.fabasoad.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution_451 {

  public static void main(String[] args) {
    assert "eert".equals(frequencySort("tree"));
    assert "aaaccc".equals(frequencySort("cccaaa"));
    assert "bbAa".equals(frequencySort("Aabb"));
  }

  public static String frequencySort(String s) {
    final Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.merge(s.charAt(i), 1, Integer::sum);
    }
    final SortedSet<int[]> set = new TreeSet<>((a, b) -> {
      if (a[1] > b[1]) {
        return -1;
      } else if (a[1] < b[1]) {
        return 1;
      }
      return Integer.compare(a[0], b[0]);
    });
    for (final Map.Entry<Character, Integer> entry : map.entrySet()) {
      set.add(new int[] { entry.getKey(), entry.getValue() });
    }
    final StringBuilder sb = new StringBuilder();
    for (final int[] pair : set) {
      for (int i = 0; i < pair[1]; i++) {
        sb.append(Character.toChars(pair[0]));
      }
    }
    return sb.toString();
  }
}
