package com.fabasoad.leetcode.easy;

public class Solution_1576 {

  private static int find(int left, int right) {
    for (int i = 97; i < 123; i++) {
      if (i != left && i != right) {
        return i;
      }
    }
    return -1;
  }

  public static String modifyString(String s) {
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '?') {
        int left = i == 0 ? -1 : s.charAt(i - 1);
        int right = i == s.length() - 1 ? -1 : s.charAt(i + 1);
        int repl = find(left, right);
        String s2 = "";
        if (left != -1) {
          s2 += s.substring(0, i);
        }
        s2 += String.valueOf(Character.toChars(repl));
        if (right != -1) {
          s2 += s.substring(i + 1);
        }
        s = s2;
      }
    }
    return s;
  }

  public static void main(String[] args) {
    assert modifyString("?zs").equals("azs");
    assert modifyString("a?zs?").equals("abzsa");
    assert modifyString("").equals("");
    assert modifyString("?").equals("a");
    assert modifyString("ubv?w").equals("ubvaw");
    assert modifyString("ubv???w").equals("ubvabaw");
    assert modifyString("ubv???a").equals("ubvabca");
  }
}
