package com.fabasoad.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_111 {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  private static class Pair {
    TreeNode node;
    int depth;
    Pair(TreeNode node, int depth) {
      this.node = node;
      this.depth = depth;
    }
  }

  public int minDepth(TreeNode root) {
    int depth = 0;
    if (root != null) {
      final Queue<Pair> queue = new ArrayDeque<>();
      queue.add(new Pair(root, 1));
      while (!queue.isEmpty()) {
        final Pair n = queue.poll();
        depth = n.depth;
        if (n.node.left == null && n.node.right == null) {
          break;
        }
        if (n.node.left != null) {
          queue.add(new Pair(n.node.left, n.depth + 1));
        }
        if (n.node.right != null) {
          queue.add(new Pair(n.node.right, n.depth + 1));
        }
      }
    }
    return depth;
  }

  public static void main(String[] args) {
    final Solution_111 s = new Solution_111();
    assert 2 == s.minDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(17))));
    assert 5 == s.minDepth(new TreeNode(2, new TreeNode(3, new TreeNode(4, new TreeNode(5, new TreeNode(6), null), null), null), null));
    assert 2 == s.minDepth(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3)));
  }
}
