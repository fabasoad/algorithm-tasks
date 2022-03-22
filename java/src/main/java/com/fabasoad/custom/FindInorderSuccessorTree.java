package com.fabasoad.custom;

class FindInorderSuccessorTree {

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

  private static void traverse(TreeNode node, TreeNode target, boolean[] found, TreeNode[] bag) {
    if (node == null || bag[0] != null) {
      return;
    }
    traverse(node.left, target, found, bag);
    if (found[0] && bag[0] == null) {
      bag[0] = node;
    }
    if (node.val == target.val) {
      found[0] = true;
    }
    traverse(node.right, target, found, bag);
  }

  private static TreeNode findInorderSuccessorTree(TreeNode root, TreeNode target) {
    final TreeNode[] bag = new TreeNode[1];
    traverse(root, target, new boolean[1], bag);
    return bag[0];
  }

  public static void main(String[] args) {
    final TreeNode node_11 = new TreeNode(11);
    final TreeNode node_14 = new TreeNode(14);
    final TreeNode node_9 = new TreeNode(9, new TreeNode(5), new TreeNode(12, node_11, node_14));
    final TreeNode node_20 = new TreeNode(20, node_9, new TreeNode(25));
//    TreeNode actual = findInorderSuccessorTree(node_20, node_9);
//    assert node_11 == actual;
    TreeNode actual = findInorderSuccessorTree(node_20, node_14);
    assert node_20 == actual;
  }
}
