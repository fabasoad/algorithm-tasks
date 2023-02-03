package com.fabasoad.leetcode.easy;

public class Solution_202 {
  private int calc(int n, int digNum) {
    int sum = 0;
    long k;
    while (n > 0) {
      k = (long) Math.pow(10, digNum);
      final long d = n / k;
      sum += Math.pow(d, 2);
      n = (int) (n % k);
      digNum--;
    }
    return sum;
  }

  private int countDigit(int n) {
    int count = 0;
    while (n != 0) {
      n = n / 10;
      count++;
    }
    return count;
  }

  public boolean isHappy(int n) {
    int marker = 4;
    boolean passed = false;
    boolean result = true;
    while (n != 1) {
      n = calc(n, countDigit(n));
      if (n == marker) {
        if (passed) {
          result = false;
          break;
        } else {
          passed = true;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    final var s = new Solution_202();
    assert s.isHappy(19);
    assert !s.isHappy(2);
    assert s.isHappy(7);
    assert !s.isHappy(3);
    assert !s.isHappy(1999999999);
    assert !s.isHappy(2147483647);
  }
}
