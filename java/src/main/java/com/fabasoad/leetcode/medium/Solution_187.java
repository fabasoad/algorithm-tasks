package com.fabasoad.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

// https://leetcode.com/problems/repeated-dna-sequences/
public class Solution_187 {

  public static void main(String[] args) {
    final List<String> res1 = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    assert 2 == res1.size();
    assert Objects.equals("AAAAACCCCC", res1.get(0));
    assert Objects.equals("CCCCCAAAAA", res1.get(1));
    final List<String> res2 = findRepeatedDnaSequences("AAAAAAAAAAAAA");
    assert 1 == res2.size();
    assert Objects.equals("AAAAAAAAAA", res2.get(0));
    final List<String> res3 = findRepeatedDnaSequences("AAAAAAAAAAA");
    assert 1 == res3.size();
    assert Objects.equals("AAAAAAAAAA", res3.get(0));
  }

  public static List<String> findRepeatedDnaSequences(String s) {
    if (s.length() < 10) {
      return Collections.emptyList();
    }
    final Map<String, Integer> map = new HashMap<>();
    int start = 0;
    while (true) {
      final int end = start + 10;
      if (end > s.length()) {
        break;
      }
      map.merge(s.substring(start, end), 1, Integer::sum);
      start++;
    }
    List<String> finalList = new ArrayList<>();
    for (final Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() > 1) {
        finalList.add(entry.getKey());
      }
    }
    return finalList;
  }
}
