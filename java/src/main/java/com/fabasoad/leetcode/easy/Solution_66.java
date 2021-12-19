package com.fabasoad.leetcode.easy;

import java.util.Arrays;

public class Solution_66 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
    System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
    System.out.println(Arrays.toString(plusOne(new int[]{0})));
    System.out.println(Arrays.toString(plusOne(new int[]{9})));
  }

  public static int[] plusOne(int[] digits) {
    int delta = 1;
    for (int d : digits) {
      if (d < 9) {
        delta = 0;
        break;
      }
    }
    int[] res = new int[digits.length + delta];
    int counter = res.length - 1;
    int buff = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      int newNum = digits[i] + buff;
      if (newNum > 9) {
        res[counter] = 0;
        buff = newNum - 9;
      } else {
        res[counter] = newNum;
        buff = 0;
      }
      counter--;
    }
    if (counter >= 0) {
      res[counter] = 1;
    }
    return res;
  }
}
