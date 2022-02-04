package com.fabasoad.leetcode.medium;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_1353 {

  // TODO: need to be finished
  public int maxEvents(int[][] events) {
    final List<int[]> sorted = Arrays.stream(events)
        .sorted((a, b) -> a[0] < b[0]
            ? -1
            : (a[0] > b[0]
              ? 1
              : Integer.compare(b[1], a[1])))
        .collect(Collectors.toList());
    int last = -1;
    int count = 0;
    for (int i = 0; i < sorted.size(); i++) {
      int[] event = sorted.get(i);
      if (last == -1) {
        last = i;
        count++;
      } else {
        if (event[1] > sorted.get(last)[0]) {
          last = i;
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    final Solution_1353 s = new Solution_1353();
    assert 3 == s.maxEvents(new int[][] {{1,2},{2,3},{3,4}});
    assert 4 == s.maxEvents(new int[][] {{1,2},{2,3},{3,4},{1,2}});
    assert 5 == s.maxEvents(new int[][] {{1,2},{1,2},{3,3},{1,5},{1,5}});
    assert 4 == s.maxEvents(new int[][] {{1,4},{4,4},{2,2},{3,4},{1,1}});
    assert 7 == s.maxEvents(new int[][] {{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}});
  }
}
