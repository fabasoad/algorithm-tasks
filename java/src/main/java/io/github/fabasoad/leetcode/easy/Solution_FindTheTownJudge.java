package io.github.fabasoad.leetcode.easy;

import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/find-the-town-judge/
 */
public class Solution_FindTheTownJudge {

  public static void main(final String[] args) {
    int actual = findJudge(2, new int[][] { { 1, 2 } });
    assert actual == 2;
    actual = findJudge(3, new int[][] { { 1, 3 }, { 2, 3 } });
    assert actual == 3;
    actual = findJudge(3, new int[][] { { 1, 3 }, { 2, 3 }, { 3, 1 } });
    assert actual == -1;
    actual = findJudge(3, new int[][] { { 1, 2 }, { 2, 3 } });
    assert actual == -1;
    actual = findJudge(4, new int[][] { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } });
    assert actual == 3;
  }

  /**
   * O(n^2)
   */
  public static int findJudge(int N, int[][] trust) {
    final var set = new HashSet<Integer>();
    for (final int[] t : trust) {
      set.add(t[0]);
    }
    if (set.size() == N) {
      return -1;
    }
    final var resultSet = new HashSet<Integer>();
    IntStream.range(1, N + 1).forEach(resultSet::add);
    for (final int a : set) {
      resultSet.remove(a);
    }
    if (resultSet.size() > 1) {
      return -1;
    }
    if (resultSet.size() == 0) {
      return -1;
    }
    final int result = resultSet.iterator().next();
    for (int cur = 1; cur <= N; cur++) {
      if (cur == result) {
        continue;
      }
      if (!exists(new int[] { cur, result }, trust)) {
        return -1;
      }
    }
    return result;
  }

  private static boolean exists(int[] pair, int[][] trust) {
    for (int[] t : trust) {
      if (t[0] == pair[0] && t[1] == pair[1]) {
        return true;
      }
    }
    return false;
  }
}
