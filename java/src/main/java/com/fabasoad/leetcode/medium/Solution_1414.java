package com.fabasoad.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution_1414 {

  private static void fib(List<Integer> nums, int prev, int curr, int limit) {
    if (curr > limit) {
      return;
    }
    nums.add(curr);
    fib(nums, curr, prev + curr, limit);
  }

  public int findMinFibonacciNumbers(int k) {
    final List<Integer> nums = new ArrayList<>();
    nums.add(1);
    fib(nums, 1, 1, k);
    int counter = 0;
    for (int i = nums.size() - 1; i >= 0 && k > 0; i--) {
      if (nums.get(i) <= k) {
        k -= nums.get(i);
        counter++;
      }
    }
    return counter;
  }

  public static void main(String[] args) {
    final Solution_1414 s = new Solution_1414();
    assert 2 == s.findMinFibonacciNumbers(7);
    assert 2 == s.findMinFibonacciNumbers(10);
    assert 3 == s.findMinFibonacciNumbers(19);
  }
}
