package com.fabasoad.leetcode.medium;

public class Solution_1689 {

  public int minPartitions(String n) {
    int max = 0;
    for (int i = 0 ; i < n.length(); i++){
      max = Math.max(max, n.charAt(i) - '0');
    }
    return max;
  }

  public static void main(String[] args) {
    final Solution_1689 s = new Solution_1689();
    assert 3 == s.minPartitions("32");
    assert 8 == s.minPartitions("82734");
    assert 9 == s.minPartitions("27346209830709182346");
    assert 5 == s.minPartitions("200500000000550");
  }
}
