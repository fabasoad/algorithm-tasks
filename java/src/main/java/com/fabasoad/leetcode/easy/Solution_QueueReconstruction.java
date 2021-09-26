package com.fabasoad.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 */
public class Solution_QueueReconstruction {

  public static void main(String[] args) {
    reconstructQueue(new int[][] {
        new int[] { 6, 0 },
        new int[] { 5, 0 },
        new int[] { 4, 0 },
        new int[] { 3, 2 },
        new int[] { 2, 2 },
        new int[] { 1, 4 }
    });
  }

  public static int[][] reconstructQueue(int[][] people) {
    // [[5,0],[6,0],[4,0],[3,2],[2,2],[1,4]]
    // [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
    Arrays.sort(people, (a1, a2) -> {
      if (a1[0] == a2[0]) {
        return a1[1] < a2[1] ? 1 : -1;
      }
      return a1[0] > a2[0] ? 1 : -1;
    });
    for (int i = people.length - 1; i >= 0; i--) {
      int s = people[i][1];
      if (s == 0) {
        continue;
      }
      for (int j = i; j < i + s; j++) {
        swap(people, j, j + 1);
      }
    }
    return people;
  }

  private static void swap(int[][] a, int i1, int i2) {
    int[] t = a[i2];
    a[i2] = a[i1];
    a[i1] = t;
  }
}
