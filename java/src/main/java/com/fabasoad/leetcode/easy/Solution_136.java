package com.fabasoad.leetcode.easy;

public class Solution_136 {
  private static final int NUM = 3 * (int) Math.pow(10, 4);

  public static void main(String[] args) {
    assert 1 == singleNumber(new int[] { 2, 2, 1 });
    assert 4 == singleNumber(new int[] { 4, 1, 2, 1, 2 });
    assert 1 == singleNumber(new int[] { 1 });
    assert 354 == singleNumber(new int[] { -336,513,-560,-481,-174,101,-997,40,-527,-784,-283,-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,354 });
  }

  public static int singleNumber(int[] nums) {
    final int[] arr = new int[2 * NUM];
    for (int num : nums) {
      arr[num + NUM] += 1;
    }
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 1) {
        return i - NUM;
      }
    }
    return 1;
  }
}
