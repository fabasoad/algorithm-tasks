package com.fabasoad.leetcode.medium;

public class Solution_371 {

  public static void main(String[] args) {
    System.out.println(getSum(2, 3));
  }

  public static int getSum(int a, int b) {
    while (b != 0) {
      int carry = a & b;
      a = a ^ b;
      b = carry << 1;
    }
    return a;
  }
}
