package com.fabasoad.leetcode.easy;

public class Solution_520 {

  public static boolean detectCapitalUse(String word) {
    // capitals: 65-90
    boolean lowercase = true;
    boolean uppercase = true;
    boolean firstUppercase = false;
    for (int i = 0; i < word.length(); i++) {
      final char c = word.charAt(i);
      final boolean isLowercase = c < 65 || c > 90;
      lowercase &= isLowercase;
      uppercase &= !isLowercase;
      if (!isLowercase) {
        firstUppercase = i == 0;
      }
    }
    return lowercase || uppercase || firstUppercase;
  }

  public static void main(String[] args) {
    assert detectCapitalUse("USA");
    assert detectCapitalUse("leetcode");
    assert detectCapitalUse("Google");
    assert !detectCapitalUse("FlaG");
  }
}
