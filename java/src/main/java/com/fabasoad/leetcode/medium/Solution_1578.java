package com.fabasoad.leetcode.medium;

public class Solution_1578 {

  public int minCost(String colors, int[] neededTime) {
    if (colors.isEmpty()) {
      return 0;
    }
    int last = 0;
    int sum = 0;
    for (int i = 1; i < colors.length(); i++) {
      if (colors.charAt(i) == colors.charAt(last)) {
        final int ind;
        if (neededTime[i] < neededTime[last]) {
          ind = i;
        } else {
          ind = last;
          last = i;
        }
        sum += neededTime[ind];
      } else {
        last = i;
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    final Solution_1578 s = new Solution_1578();
    assert 3 == s.minCost("abaac", new int[] { 1,2,3,4,5 });
    assert 0 == s.minCost("abc", new int[] { 1,2,3 });
    assert 2 == s.minCost("aabaa", new int[] { 1,2,3,4,1 });
    assert 26 == s.minCost("aaabbbabbbb", new int[] { 3,5,10,7,5,3,5,5,4,8,1 });
  }
}
