package com.fabasoad.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

class Solution_1781 {

  private int calcBeauty(Map<Character, Integer> map) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int val : map.values()) {
      if (val > max) {
        max = val;
      }
      if (val < min) {
        min = val;
      }
    }
    return Math.max(0, max - min);
  }

  public int beautySum(String s) {
    int total = 0;
    for (int i = 0; i < s.length(); i++) {
      final Map<Character, Integer> map = new HashMap<>();
      for (int j = i; j < s.length(); j++) {
        map.merge(s.charAt(j), 1, Integer::sum);
        total += calcBeauty(map);
      }
    }
    return total;
  }

  public static void main(String[] args) {
    final Solution_1781 s = new Solution_1781();
    assert 17 == s.beautySum("aabcbaa");
    final int actual = s.beautySum("purqgxcjclculvgnzuvahjwlncdaboxrrdcfgvdahtuikvpansfujddcpuigpceamkcopgtijycxtwztubqyydqeukdtxdbluszbtwoeklgrighhdkkqfcwebtijtlwcbss");
    assert 30903 == actual;
  }
}