package com.fabasoad.leetcode.easy;

public class Solution_100 {

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

  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null) {
      return q == null;
    }
    if (q == null) {
      return false;
    }
    return p.val == q.val
        && isSameTree(p.left, q.left)
        && isSameTree(p.right, q.right);
  }

  public static void main(String[] args) {
    assert isSameTree(
        new TreeNode(1, new TreeNode(2), new TreeNode(3)),
        new TreeNode(1, new TreeNode(2), new TreeNode(3)));
    assert !isSameTree(
        new TreeNode(1, new TreeNode(2), new TreeNode(1)),
        new TreeNode(1, new TreeNode(1), new TreeNode(2)));
    assert !isSameTree(
        new TreeNode(1, null, new TreeNode(2)),
        new TreeNode(1, new TreeNode(2), null));
  }
}
