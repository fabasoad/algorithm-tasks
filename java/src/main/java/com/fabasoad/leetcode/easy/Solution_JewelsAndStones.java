package com.fabasoad.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_JewelsAndStones {

  public static void main(String[] args) {
    assert 3 == numJewelsInStones("aA", "aAAbbbb");
    assert 0 == numJewelsInStones("z", "ZZ");
  }

  public static int numJewelsInStones(String jewels, String stones) {
    final Map<Character, Integer> map = new HashMap<>();
    for (final char c : jewels.toCharArray()) {
      map.put(c, 0);
    }
    int total = 0;
    for (final char c : stones.toCharArray()) {
      if (map.containsKey(c)) {
        total++;
      }
    }

    return total;
  }
}
