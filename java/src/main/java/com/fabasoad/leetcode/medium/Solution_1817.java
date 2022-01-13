package com.fabasoad.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_1817 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(findingUsersActiveMinutes(new int[][]{
        {0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}
    }, 5)));
  }

  public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
    final int[] res = new int[k];
    final Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < logs.length; i++) {
      final int id = logs[i][0];
      final int time = logs[i][1];
      map.compute(id, (key, val) -> {
        if (val == null) {
          return new HashSet<>(Set.of(time));
        }
        val.add(time);
        return val;
      });
    }
    for (final Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
      res[entry.getValue().size() - 1]++;
    }
    return res;
  }
}
