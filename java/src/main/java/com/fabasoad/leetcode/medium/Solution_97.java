package com.fabasoad.leetcode.medium;

public class Solution_97 {

  public boolean isInterleave(String s1, int s1i, String s2, int s2i, String s3, int s3i, int[][] table) {
    if (s1i == s1.length() && s2i == s2.length() && s3i == s3.length()) {
      return true;
    }
    boolean res1 = false;
    if (s1i < s1.length() && s3i < s3.length() && s1.charAt(s1i) == s3.charAt(s3i)) {
      if (table[s1i + 1][s2i] == 0) {
        table[s1i + 1][s2i] = isInterleave(s1, s1i + 1, s2, s2i, s3, s3i + 1, table) ? 2 : 1;
      }
      res1 = table[s1i + 1][s2i] == 2;
    }
    boolean res2 = false;
    if (s2i < s2.length() && s3i < s3.length() && s2.charAt(s2i) == s3.charAt(s3i)) {
      if (table[s1i][s2i + 1] == 0) {
        table[s1i][s2i + 1] = isInterleave(s1, s1i, s2, s2i + 1, s3, s3i + 1, table) ? 2 : 1;
      }
      res2 = table[s1i][s2i + 1] == 2;
    }
    return res1 || res2;
  }

  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }
    return isInterleave(s1, 0, s2, 0, s3, 0, new int[s1.length() + 1][s2.length() + 1]);
  }

  public static void main(String[] args) {
    final Solution_97 s = new Solution_97();
    System.out.println(s.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    System.out.println(s.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    System.out.println(s.isInterleave("", "", ""));
    String s1 = "accbaabaaabbcbaacbababacaababbcbabaababcaabbbbbcacbaa";
    String s2 = "cabaabcbabcbaaaacababccbbccaaabaacbbaaabccacabaaccbbcbcb";
    String s3 = "accbcaaabbaabaaabbcbcbabacbacbababaacaaaaacbabaabbcbccbbabbccaaaaabaabcabbcaabaaabbcbcbbbcacabaaacccbbcbbaacb";
    System.out.println(s.isInterleave(s1, s2, s3));
  }
}
