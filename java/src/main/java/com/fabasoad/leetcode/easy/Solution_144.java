package com.fabasoad.leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution_144 {

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
    System.out.println(preorderTraversal(new TreeNode(1, new TreeNode(4, new TreeNode(2), null), new TreeNode(3))));
  }

  private static void preorder(TreeNode node, List<Integer> res) {
    if (node != null) {
      res.add(node.val);
      preorder(node.left, res);
      preorder(node.right, res);
    }
  }

  public static List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    preorder(root, res);
    return res;
  }
}
