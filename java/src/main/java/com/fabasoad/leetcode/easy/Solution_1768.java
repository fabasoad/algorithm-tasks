package com.fabasoad.leetcode.easy;

public class Solution_1768 {

  public static void main(String[] args) {
    assert "apbqcr".equals(mergeAlternately("abc", "pqr"));
    assert "apbqrs".equals(mergeAlternately("ab", "pqrs"));
    assert "apbqcd".equals(mergeAlternately("abcd", "pq"));
  }

  private static void leftover(int x, String word, StringBuilder sb) {
    if (x < word.length()) {
      for (int k = x; k < word.length(); k++) {
        sb.append(word.charAt(k));
      }
    }
  }

  public static String mergeAlternately(String word1, String word2) {
    int i = 0;
    int j = 0;
    final StringBuilder sb = new StringBuilder();
    while (i < word1.length() && j < word2.length()) {
      sb.append(word1.charAt(i));
      sb.append(word2.charAt(j));
      i++;
      j++;
    }
    leftover(i, word1, sb);
    leftover(j, word2, sb);
    return sb.toString();
  }
}
