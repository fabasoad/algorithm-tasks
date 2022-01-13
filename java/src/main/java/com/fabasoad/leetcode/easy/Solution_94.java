package com.fabasoad.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution_94 {

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

  private static void traverse(TreeNode node, List<Integer> res) {
    if (node != null) {
      traverse(node.left, res);
      res.add(node.val);
      traverse(node.right, res);
    }
  }

  public static List<Integer> inorderTraversal(TreeNode root) {
    final List<Integer> res = new ArrayList<>();
    traverse(root, res);
    return res;
  }

  public static void main(String[] args) {
    final List<Integer> res = inorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)));
    System.out.println(res);
  }
}
