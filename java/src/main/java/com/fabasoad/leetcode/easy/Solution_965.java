package com.fabasoad.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_965 {

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

  public boolean isUnivalTree(TreeNode root) {
    int expected = root.val;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      final TreeNode node = queue.poll();
      if (node.val != expected) {
        return false;
      }
      if (node.left != null) queue.add(node.left);
      if (node.right != null) queue.add(node.right);
    }
    return true;
  }
}
