package com.fabasoad.leetcode.easy;

public class Solution_28 {

  public static void main(String[] args) {
    assert 2 == strStr("hello", "ll");
    assert 3 == strStr("hello", "lo");
    assert -1 == strStr("aaaaa", "bba");
    assert 0 == strStr("", "");
    assert -1 == strStr("aaa", "aaaa");
  }

  // Rabin-Karp algorithm
  public static int strStr(String haystack, String needle) {
    if (needle.isEmpty() || haystack.equals(needle)) {
      return 0;
    }
    final int hash1 = needle.hashCode();
    final int end = haystack.length() - needle.length() + 1;
    for (int i = 0; i < end; i++) {
      final int hash2 = haystack.substring(i, i + needle.length()).hashCode();
      if (hash1 == hash2) {
        return i;
      }
    }
    return -1;
  }

  // Slower solution
  public static int strStr2(String haystack, String needle) {
    if (needle.isEmpty() || haystack.equals(needle)) {
      return 0;
    }
    int i = 0;
    int j = 0;
    while (i < haystack.length() && j < needle.length()) {
      if (i + j < haystack.length() && haystack.charAt(i + j) == needle.charAt(j)) {
        j++;
      } else {
        i++;
        j = 0;
      }
    }
    return i == haystack.length() ? -1 : i;
  }
}
