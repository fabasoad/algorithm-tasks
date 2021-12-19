package com.fabasoad.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution_93 {

  public static void main(String[] args) {
    List<String> res = restoreIpAddresses("255255111135");
    assert 1 == res.size();
    res = restoreIpAddresses("255255111256");
    assert 0 == res.size();
    res = restoreIpAddresses("255255264255");
    assert 0 == res.size();
    res = restoreIpAddresses("255311254255");
    assert 0 == res.size();
    res = restoreIpAddresses("0000");
    assert 1 == res.size();
    res = restoreIpAddresses("1111");
    assert 1 == res.size();
    res = restoreIpAddresses("111");
    assert 0 == res.size();
    res = restoreIpAddresses("2552552552551");
    assert 0 == res.size();
    // here
    res = restoreIpAddresses("25525511135");
    assert 2 == res.size();
    res = restoreIpAddresses("010010");
    assert 2 == res.size();
    res = restoreIpAddresses("101023");
    assert 5 == res.size();
  }

  public static List<String> restoreIpAddresses(String s) {
    final List<String> res = new ArrayList<>();
    parse("", s, 0, res);
    return res;
  }

  private static String concat(String left, int iter, String right) {
    return String.format("%s%s%s", left, iter == 0 ? "" : ".", right);
  }

  private static boolean isValid(String num) {
    if (num.length() == 0 || num.length() > 3) {
      return false;
    }
    if (num.startsWith("0") && num.length() > 1) {
      return false;
    }
    return Integer.parseInt(num) < 256;
  }

  private static void parse(String left, String right, int iter, List<String> res) {
    if (iter == 3) {
      if (isValid(right)) {
        res.add(left + "." + right);
      }
    } else {
      for (int i = 1; i <= 3; i++) {
        if (i <= right.length()) {
          final String num = right.substring(0, i);
          if (isValid(num)) {
            parse(concat(left, iter, num), right.substring(i), iter + 1, res);
          }
        }
      }
    }
  }
}
