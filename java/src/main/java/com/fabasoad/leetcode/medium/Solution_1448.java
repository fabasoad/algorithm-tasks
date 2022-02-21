package com.fabasoad.leetcode.medium;

public class Solution_1448 {

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

  private static int trace(TreeNode node, int max, int count) {
    if (node.val >= max) {
      max = node.val;
      count++;
    }
    int left = 0;
    if (node.left != null) {
      left = trace(node.left, max, count) - count;
    }
    int right = 0;
    if (node.right != null) {
      right = trace(node.right, max, count) - count;
    }
    return left + right + count;
  }

  public int goodNodes(TreeNode root) {
    return trace(root, Integer.MIN_VALUE, 0);
  }

  public static void main(String[] args) {
    final Solution_1448 s = new Solution_1448();
    assert 4 == s.goodNodes(new TreeNode(3,
        new TreeNode(1, new TreeNode(3), null),
        new TreeNode(4, new TreeNode(1), new TreeNode(5))));
    assert 3 == s.goodNodes(new TreeNode(3,
        new TreeNode(3, new TreeNode(4), new TreeNode(2)), null));
    assert 1 == s.goodNodes(new TreeNode(1));
  }
}
