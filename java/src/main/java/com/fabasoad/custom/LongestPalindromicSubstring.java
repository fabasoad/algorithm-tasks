package com.fabasoad.custom;

class LongestPalindromicSubstring {

  private static String calc(String str, int l, int h) {
    while (l >= 0 && h < str.length() && str.charAt(l) == str.charAt(h)) {
      l--;
      h++;
    }
    return str.substring(l + 1, h);
  }

  private static String findLongestPalindromicSubstring(String str) {
    String last = "";
    for (int i = 0; i < str.length(); i++) {
      // odd
      String res = calc(str, i, i);
      last = res.length() > last.length() ? res : last;
      // even
      res = calc(str, i, i + 1);
      last = res.length() > last.length() ? res : last;
    }
    return last;
  }

  public static void main(String[] args) {
    System.out.println(findLongestPalindromicSubstring("babad"));
    System.out.println(findLongestPalindromicSubstring("16tabab"));
    System.out.println(findLongestPalindromicSubstring("cbbd"));
    System.out.println(findLongestPalindromicSubstring("ac"));
    System.out.println(findLongestPalindromicSubstring("a"));
    System.out.println(findLongestPalindromicSubstring("bb"));
  }
}

// babad
// dabab

