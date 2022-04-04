package com.fabasoad.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DFS {

  private static class TreeNode {
    int val;
    List<TreeNode> children;
    TreeNode parent;
    TreeNode(int val) {
      this.val = val;
      this.children = new ArrayList<>();
    }
  }

  private static void print(TreeNode node) {
    if (node == null) {
      return;
    }
    System.out.println(node.val);
    for (TreeNode child : node.children) {
      print(child);
    }
  }

  private static void dfs(int[][] tree) {
    final Map<Integer, TreeNode> map = new HashMap<>();
    for (int[] pair : tree) {
      if (!map.containsKey(pair[0])) {
        map.put(pair[0], new TreeNode(pair[0]));
      }
      if (!map.containsKey(pair[1])) {
        map.put(pair[1], new TreeNode(pair[1]));
      }
      final TreeNode parent = map.get(pair[0]);
      final TreeNode child = map.get(pair[1]);
      child.parent = parent;
      parent.children.add(child);
    }
    for (TreeNode node : map.values()) {
      if (node.parent == null) {
        print(node);
        break;
      }
    }
  }

  public static void main(String[] args) {
    dfs(new int[][] {{1,2},{1,3},{2,4},{3,5},{2,6}});
  }
}
