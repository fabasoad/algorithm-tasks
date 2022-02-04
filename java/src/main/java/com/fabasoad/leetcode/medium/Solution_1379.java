package com.fabasoad.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_1379 {

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

  public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
    final Queue<TreeNode> queue1 = new ArrayDeque<>();
    queue1.add(original);
    final Queue<TreeNode> queue2 = new ArrayDeque<>();
    queue2.add(cloned);
    while (!queue1.isEmpty() && !queue2.isEmpty()) {
      final TreeNode n1 = queue1.poll();
      final TreeNode n2 = queue2.poll();
      if (n1 == target) {
        return n2;
      }
      if (n1.left != null) {
        queue1.add(n1.left);
      }
      if (n1.right != null) {
        queue1.add(n1.right);
      }
      if (n2.left != null) {
        queue2.add(n2.left);
      }
      if (n2.right != null) {
        queue2.add(n2.right);
      }
    }
    return null;
  }
}
