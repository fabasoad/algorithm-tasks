package com.fabasoad.custom;

class RobotPath {

  public static int paths(int n, int m, int[][] cache) {
    if (n < 1 || m < 1) {
      return 0;
    }
    if (n == 1 && m == 1) {
      return 1;
    }
    if (cache[n][m] != 0) {
      return cache[n][m];
    }
    cache[n][m] = paths(n - 1, m, cache) + paths(n, m - 1, cache);
    return cache[n][m];
  }

  public static int paths(int n, int m) {
    return paths(n - 1, m - 1, new int[n][m]);
  }

  public static void main(String[] args) {
    int actual = paths(3, 4);
    assert 3 == actual;
    actual = paths(4, 5);
    assert 10 == actual;
  }
}
