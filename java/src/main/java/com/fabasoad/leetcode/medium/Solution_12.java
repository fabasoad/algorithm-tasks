package com.fabasoad.leetcode.medium;

public class Solution_12 {

  /*
  Symbol       Value
  I             1
  V             5
  X             10
  L             50
  C             100
  D             500
  M             1000
  */

  public String intToRoman(int num) {
    final StringBuilder sb = new StringBuilder();
    final int thousands = num / 1000;
    // Constraint is 1 <= num <= 3999
    if (thousands > 0) {
      sb.append("M".repeat(thousands));
      num %= 1000;
    }
    int hundreds = num / 100;
    if (hundreds > 0) {
      if (hundreds == 9) {
        sb.append("CM");
      } else if (hundreds == 4) {
        sb.append("CD");
      } else {
        if (hundreds >= 5) {
          sb.append("D");
          hundreds -= 5;
        }
        if (hundreds > 0) {
          sb.append("C".repeat(hundreds));
        }
      }
      num %= 100;
    }
    int tens = num / 10;
    if (tens > 0) {
      if (tens == 9) {
        sb.append("XC");
      } else if (tens == 4) {
        sb.append("XL");
      } else {
        if (tens >= 5) {
          sb.append("L");
          tens -= 5;
        }
        if (tens > 0) {
          sb.append("X".repeat(tens));
        }
      }
      num %= 10;
    }
    int last = num;
    if (last > 0) {
      if (last == 9) {
        sb.append("IX");
      } else if (last == 4) {
        sb.append("IV");
      } else {
        if (last >= 5) {
          sb.append("V");
          last -= 5;
        }
        if (last > 0) {
          sb.append("I".repeat(last));
        }
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    final Solution_12 s = new Solution_12();
    assert "III".equals(s.intToRoman(3));
    assert "LVIII".equals(s.intToRoman(58));
    assert "MCMXCIV".equals(s.intToRoman(1994));
  }
}
