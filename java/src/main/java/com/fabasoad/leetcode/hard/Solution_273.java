package com.fabasoad.leetcode.hard;

import java.util.StringJoiner;

public class Solution_273 {

  private final static String[] N_1 = new String[] {
      "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"
  };
  private final static String[] N_2 = new String[] {
      "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
  };
  private final static String[] N_3 = new String[] {
      "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
  };
  private final static String[] N_4 = new String[] {
      "Hundred", "Thousand", "Million", "Billion"
  };
  
  private String hundredToWords(int num) {
    var sj = new StringJoiner(" ");
    int delta;
    if (num >= 100) {
      delta = num / 100;
      sj.add(N_1[delta - 1]);
      sj.add(N_4[0]);
      num %= 100;
    }
    if (num > 10) {
      delta = num / 10;
      if (delta > 1) {
        sj.add(N_3[delta - 1]);
        num %= 10;
      } else {
        sj.add(N_2[num % 10 - 1]);
        num = 0;
      }
    }
    if (num > 0) {
      sj.add(N_1[num - 1]);
    }
    return sj.toString();
  }
  
  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }
    var sj = new StringJoiner(" ");
    final int billion = 1_000_000_000;
    final int million = 1_000_000;
    final int thousand = 1_000;
    int delta;
    if (num >= billion) {
      delta = num / billion;
      sj.add(N_1[delta - 1]);
      sj.add(N_4[3]);
      num %= billion;
    }
    if (num >= million) {
      sj.add(hundredToWords(num / million));
      sj.add(N_4[2]);
      num %= million;
    }
    if (num >= thousand) {
      sj.add(hundredToWords(num / thousand));
      sj.add(N_4[1]);
      num %= thousand;
    }
    if (num > 0) {
      sj.add(hundredToWords(num));
    }
    return sj.toString();
  }

  public static void main(String[] args) {
    final var s = new Solution_273();
    assert "One Hundred Twenty Three".equals(s.numberToWords(123));
    assert "Twelve Thousand Three Hundred Forty Five".equals(s.numberToWords(12345));
    assert "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven".equals(s.numberToWords(1234567));
    assert "Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven".equals(s.numberToWords(2_147_483_647));
    assert "Zero".equals(s.numberToWords(0));
    assert "Ten".equals(s.numberToWords(10));
    assert "One Hundred".equals(s.numberToWords(100));
    assert "One Thousand".equals(s.numberToWords(1000));
    assert "Ten Thousand".equals(s.numberToWords(10000));
    assert "Twenty Thousand".equals(s.numberToWords(20000));
  }
}
