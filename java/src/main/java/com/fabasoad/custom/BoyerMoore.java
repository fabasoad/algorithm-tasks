package com.fabasoad.custom;

import java.util.HashMap;
import java.util.Map;

class BoyerMoore {

  //          0123456789&
  // text:    This is a test
  // pattern: test
  // map:     t -> 1, e -> 2, s -> 1, * -> 4
  private static int search(String text, String pattern) {
    final Map<Character, Integer> map = new HashMap<>();
    final int otherChar = pattern.length();
    for (int i = 0; i < pattern.length(); i++) {
      final int val = Math.max(1, pattern.length() - i - 1);
      map.put(pattern.charAt(i), val);
    }
    int text_i = pattern.length() - 1;
    int last_text_i = text_i;
    int pattern_i = pattern.length() - 1;
    while (pattern_i >= 0 && text_i < text.length()) {
      if (pattern.charAt(pattern_i) == text.charAt(text_i)) {
        pattern_i--;
        text_i--;
      } else {
        int val = map.getOrDefault(text.charAt(text_i), otherChar);
        text_i = last_text_i + val;
        last_text_i = text_i;
        pattern_i = pattern.length() - 1;
      }
    }
    if (pattern_i == -1) {
      return text_i + 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    final String text = "This is a test";
    int actual = search(text, "test");
    assert 10 == actual;
    actual = search(text, "test1");
    assert -1 == actual;
  }
}
