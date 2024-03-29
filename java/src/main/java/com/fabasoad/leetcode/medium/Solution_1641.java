package com.fabasoad.leetcode.medium;

class Solution_1641 {

  public int countVowelStrings(int n) {
    int[][] dp = new int[n + 1][6];
    for (int i = 1; i < n + 1; i++){
      for (int j = 1; j < 6; j++) {
        if (i == 1) {
          dp[i][j] = j;
        } else {
          dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
        }
      }
    }
    return dp[n][5];
  }

  public static void main(String[] args) {
    final Solution_1641 s = new Solution_1641();
    System.out.println(s.countVowelStrings(1));
    System.out.println(s.countVowelStrings(2));
    System.out.println(s.countVowelStrings(33));
  }
}
