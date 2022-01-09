package com.fabasoad.leetcode.easy;

public class Solution_1342 {

  public int numberOfSteps(int num) {
    int steps = 0;
    while (num > 0) {
      num = (num & 1) == 0 ? num / 2 : num - 1;
      steps++;
    }
    return steps;
  }
}
