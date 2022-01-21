package com.fabasoad.leetcode.medium;

public class Solution_1325 {

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

  private static class TreeNodeP {
    TreeNode node;
    TreeNodeP parent;
    TreeNodeP(TreeNode node, TreeNodeP parent) {
      this.node = node;
      this.parent = parent;
    }
  }

  private static void traverse(TreeNodeP x, int target) {
    if (x != null && x.node != null) {
      if (x.node.left == null && x.node.right == null && x.node.val == target) {
        if (x.parent != null) {
          if (x.parent.node.left == x.node) {
            x.parent.node.left = null;
          } else {
            x.parent.node.right = null;
          }
          traverse(x.parent, target);
        }
      } else {
        traverse(new TreeNodeP(x.node.left, x), target);
        traverse(new TreeNodeP(x.node.right, x), target);
      }
    }
  }

  public static TreeNode removeLeafNodes(TreeNode root, int target) {
    traverse(new TreeNodeP(root, null), target);
    if (root != null && root.right == null && root.left == null && root.val == target) {
      return null;
    }
    return root;
  }

  public static void main(String[] args) {
    TreeNode res = removeLeafNodes(new TreeNode(1,
        new TreeNode(2, new TreeNode(2), null),
        new TreeNode(3, new TreeNode(2), new TreeNode(4))), 2);
    assert res != null;
    assert 1 == res.val;
    res = removeLeafNodes(new TreeNode(1,
        new TreeNode(3, new TreeNode(3), new TreeNode(2)),
        new TreeNode(3)), 3);
    assert res != null;
    assert 1 == res.val;
    res = removeLeafNodes(new TreeNode(1,
        new TreeNode(2, new TreeNode(2, new TreeNode(2), null), null), null), 2);
    assert res != null;
    assert 1 == res.val;
    res = removeLeafNodes(null, 5);
    assert res == null;
    res = removeLeafNodes(new TreeNode(2), 2);
    assert res == null;
    res = removeLeafNodes(new TreeNode(2, new TreeNode(2), new TreeNode(2)), 2);
    assert res == null;
  }
}
