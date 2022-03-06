package com.fabasoad.custom;

public class Solution_Calculator {

  private int updateStack(String s, int from, int to, char lastOp, int lastNum) {
    int num = Integer.parseInt(s.substring(from, to).trim());
    if (lastOp == '+') {
      return lastNum + num;
    } else if (lastOp == '-') {
      return lastNum - num;
    } else {
      return num;
    }
  }

  // Implement calculator that has +- only
  int calc(String s) {
    int lastInd = 0;
    int lastNum = 0;
    char lastOp = '0';
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '+' || s.charAt(i) == '-') {
        lastNum = updateStack(s, lastInd, i, lastOp, lastNum);
        lastOp = s.charAt(i);
        lastInd = i + 1;
      }
    }
    return updateStack(s, lastInd, s.length(), lastOp, lastNum);
  }

  public static void main(String[] args) {
    final Solution_Calculator s = new Solution_Calculator();
    assert -1 == s.calc(" 1-1-1");
    assert 1 == s.calc("1+1- 1 ");
    assert 3211 == s.calc("21+1-33 + 3222");
  }
}
