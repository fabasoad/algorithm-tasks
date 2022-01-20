package com.fabasoad.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution_145 {

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

  private static void traversal(TreeNode node, List<Integer> list) {
    if (node != null) {
      traversal(node.left, list);
      traversal(node.right, list);
      list.add(node.val);
    }
  }

  public static List<Integer> postorderTraversal(TreeNode root) {
    final List<Integer> list = new ArrayList<>();
    traversal(root, list);
    return list;
  }

  public static void main(String[] args) {
    System.out.println(postorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
  }
}
