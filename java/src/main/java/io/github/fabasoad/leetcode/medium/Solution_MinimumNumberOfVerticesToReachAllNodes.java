package io.github.fabasoad.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
 */
public class Solution_MinimumNumberOfVerticesToReachAllNodes {

  public static void main(String[] args) {
    final List<Integer> actual = findSmallestSetOfVertices(6, List.of(
        List.of(0, 1),
        List.of(0, 2),
        List.of(2, 5),
        List.of(3, 4),
        List.of(4, 2)
    ));
    assert actual.get(0) == 0;
    assert actual.get(1) == 3;
  }

  public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    final var set1 = new HashSet<Integer>();
    for (final List<Integer> edge : edges) {
      set1.add(edge.get(0));
    }
    for (final List<Integer> edge : edges) {
      set1.remove(edge.get(1));
    }
    return new ArrayList<>(set1);
  }
}
