package com.fabasoad.leetcode.medium;

public class Solution_1302 {

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

  public static void main(String[] args) {
    assert 15 == deepestLeavesSum(new TreeNode(1,
        new TreeNode(2,
            new TreeNode(4, new TreeNode(7), null),
            new TreeNode(5)),
        new TreeNode(3,
            null,
            new TreeNode(6, null, new TreeNode(8)))));
  }

  private static void traverse(TreeNode node, int level, int[] res /* 0 - max, 1 - sum */) {
    if (node != null) {
      if (node.left == null && node.right == null) {
        if (level == res[0]) {
          res[1] += node.val;
        } else if (level > res[0]) {
          res[0] = level;
          res[1] = node.val;
        }
      }
      traverse(node.left, level + 1, res);
      traverse(node.right, level + 1, res);
    }
  }

  public static int deepestLeavesSum(TreeNode root) {
    int[] res = new int[2];
    traverse(root, 1, res);
    return res[1];
  }
}
