package com.fabasoad.leetcode.easy;

public class Solution_242 {

  public static void main(String[] args) {
    assert isAnagram("anagram", "nagaram");
    assert !isAnagram("rat", "car");
  }

  public static boolean isAnagram(String s, String t) {
    final int[] letters = new int[26];
    for (int i = 0; i < s.length(); i++) {
      letters[s.charAt(i) - 97]++;
    }
    for (int i = 0; i < t.length(); i++) {
      if (letters[t.charAt(i) - 97] == 0) {
        return false;
      }
      letters[t.charAt(i) - 97]--;
    }
    for (int i = 0; i < letters.length; i++) {
      if (letters[i] > 0) {
        return false;
      }
    }
    return true;
  }
}
