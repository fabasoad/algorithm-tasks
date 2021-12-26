package com.fabasoad.leetcode.easy;

public class Solution_700 {

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

  public TreeNode searchBST(TreeNode root, int val) {
    TreeNode node = root;
    while (node != null) {
      if (node.val == val) {
        return node;
      }
      node = val < node.val ? node.left : node.right;
    }
    return null;
  }
}
