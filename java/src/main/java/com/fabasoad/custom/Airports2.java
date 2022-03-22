package com.fabasoad.custom;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

class Airports2 {

  private static class TreeNode implements Comparable<TreeNode> {
    String val;
    Set<TreeNode> children = new HashSet<>();
    TreeNode(String val) {
      this.val = val;
    }

    @Override
    public int compareTo(TreeNode other) {
      return this.val.compareTo(other.val);
    }
  }

  public static int findMinimum(
      List<String> airports, String[][] routes, String startingPoint) {
    final Map<String, TreeNode> map = new HashMap<>();
    final Set<String> airportsSet = new HashSet<>();
    for (String airport : airports) {
      if (!map.containsKey(airport)) {
        map.put(airport, new TreeNode(airport));
      }
      airportsSet.add(airport);
    }
    final Set<String> set1 = new HashSet<>();
    final Set<String> set2 = new HashSet<>();
    for (String[] route : routes) {
      final TreeNode from = map.get(route[0]);
      final TreeNode to = map.get(route[1]);
      from.children.add(to);
      set1.add(route[0]);
      set2.add(route[1]);
    }
    final Set<String> roots = set1.stream().filter(r -> !set2.contains(r)).collect(Collectors.toSet());
    for (String root : roots) {
      final Queue<TreeNode> queue = new ArrayDeque<>();
      queue.add(map.get(root));
      while (!queue.isEmpty()) {
        final TreeNode n = queue.poll();
        if (airportsSet.contains(n.val)) {
          map.remove(n.val);
          airportsSet.remove(n.val);
          queue.addAll(n.children);
        }
      }
    }
    return roots.size() + (airportsSet.size() - map.size());
  }

  public static void main(String[] args) {
    assert 3 == findMinimum(
        List.of(
            "BGI","CDG","DEL","DOH","DSM","EWR","EYW","HND","ICN",
            "JFK","LGA","LHR","ORD","SAN","SFO","SIN","TLV","BUD"),
        new String[][] {
            {"DSM","ORD"},
    {"ORD","BGI"},
    {"BGI","LGA"},
    {"SIN","CDG"},
    {"CDG","SIN"},
    {"CDG","BUD"},
    {"DEL","DOH"},
    {"DEL","CDG"},
    {"TLV","DEL"},
    {"EWR","HND"},
    {"HND","ICN"},
    {"HND","JFK"},
    {"ICN","JFK"},
    {"JFK","LGA"},
    {"EYW","LHR"},
    {"LHR","SFO"},
    {"SFO","SAN"},
    {"SFO","DSM"},
    {"SAN","EYW"}
      }, "LGA");
  }
}

