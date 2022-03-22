package com.fabasoad.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Solution_56 {
  public int[][] merge(int[][] intervals) {
    if (intervals.length < 2) {
      if (intervals.length < 1) {
        return new int[0][];
      }
      return intervals;
    }
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    final Stack<int[]> stack = new Stack<>();
    for (int i = 1; i < intervals.length; i++) {
      int[] a = stack.isEmpty() ? intervals[i - 1] : stack.pop();
      if (a[1] >= intervals[i][0]) {
        stack.add(new int[] { a[0], Math.max(a[1], intervals[i][1]) });
      } else {
        stack.add(a);
        stack.add(intervals[i]);
      }
    }
    int[][] res = new int[stack.size()][];
    int i = 0;
    while (!stack.isEmpty()) {
      res[i++] = stack.pop();
    }
    return res;
  }

  public static void main(String[] args) {
    final Solution_56 s = new Solution_56();
    System.out.println(Arrays.deepToString(s.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}))); // [[15,18],[8,10],[1,6]]
    System.out.println(Arrays.deepToString(s.merge(new int[][]{{1, 4}, {4, 5}}))); //[[1,5]]
    System.out.println(Arrays.deepToString(s.merge(new int[][]{{1, 3}}))); // [[1,3]]
    System.out.println(Arrays.deepToString(s.merge(new int[][]{{1, 4}, {2, 3}}))); // [[1,4]]
    System.out.println(Arrays.deepToString(s.merge(new int[][]{{1,4},{0,2},{3,5}}))); // [[0,5]]
  }
}
