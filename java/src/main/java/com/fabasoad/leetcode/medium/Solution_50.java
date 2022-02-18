package com.fabasoad.leetcode.medium;

public class Solution_50 {

  public double myPow(double x, int n) {
    if (n < 0) x = 1 / x;
    return func(x, Math.abs(n));
  }

  double func(double x, int n) {
    if (n == 0) return 1.0;
    double a = func(x,n/2);
    return (n % 2 == 0) ? a * a : a * a * x;
  }

  public static void main(String[] args) {
    final Solution_50 s = new Solution_50();
    assert 1024 == s.myPow(2, 10);
    assert 9.261 == s.myPow(2.1, 3);
    assert 0.25 == s.myPow(2, -2);
    assert 1 == s.myPow(1.00000, 2147483647);
    assert 0.0 == s.myPow(2.00000, -2147483648);
  }
}
