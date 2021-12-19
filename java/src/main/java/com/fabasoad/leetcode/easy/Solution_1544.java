package com.fabasoad.leetcode.easy;

public class Solution_1544 {

  public static void main(String[] args) {
    assert "leetcode".equals(makeGood("leEeetcode"));
    assert "".equals(makeGood("abBAcC"));
  }

  // TODO: Can be rewritten to stack
  private static String makeGood(String s) {
    char[] arr = s.toCharArray();
    boolean found = false;
    int i = 0;
    final StringBuilder result = new StringBuilder();
    String res;
    while (i < arr.length) {
      if (i != arr.length - 1 && (arr[i] - 32 == arr[i + 1] || arr[i] == arr[i + 1] - 32)) {
        i += 2;
        found = true;
      } else {
        result.append(arr[i]);
        i++;
      }
    }
    if (found) {
      res = makeGood(result.toString());
    } else {
      res = result.toString();
    }
    return res;
  }
}
