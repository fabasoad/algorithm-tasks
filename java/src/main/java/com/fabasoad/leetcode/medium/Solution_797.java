package com.fabasoad.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution_797 {

  private static void traverse(int[][] graph, int ind, List<Integer> path, List<List<Integer>> paths) {
    if (ind == graph.length - 1) {
      paths.add(path);
    }
    for (int i = 0; i < graph[ind].length; i++) {
      final List<Integer> copy = new ArrayList<>(path);
      copy.add(graph[ind][i]);
      traverse(graph, graph[ind][i], copy, paths);
    }
  }

  public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    final List<List<Integer>> paths = new ArrayList<>();
    final ArrayList<Integer> path = new ArrayList<>();
    path.add(0);
    traverse(graph, 0, path, paths);
    return paths;
  }

  public static void main(String[] args) {
    System.out.println(allPathsSourceTarget(new int[][] { {1, 2}, {3}, {3}, {} }));
    System.out.println(allPathsSourceTarget(new int[][] { {4,3,1},{3,2,4},{3},{4}, {} }));
    System.out.println(allPathsSourceTarget(new int[][] { {4,3,1},{3,2,4},{},{4}, {} }));
  }
}
