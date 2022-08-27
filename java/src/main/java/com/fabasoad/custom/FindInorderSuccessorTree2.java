package com.fabasoad.custom;

public class FindInorderSuccessorTree2 {

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  private static void traverse(TreeNode n, TreeNode p, boolean[] found, TreeNode[] res) {
    if (n == null) {
      return;
    }
    traverse(n.left, p, found, res);
    res[0] = n;
    if (found[0]) {
      return;
    }
    if (p.val == n.val) {
      found[0] = true;
    }
    traverse(n.right, p, found, res);
  }

  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    final TreeNode[] res = new TreeNode[1];
    traverse(root, p, new boolean[1], res);
    return res[0];
  }

  public static void main(String[] args) {
    final FindInorderSuccessorTree2 s = new FindInorderSuccessorTree2();
    final TreeNode node_11 = new TreeNode(11);
    final TreeNode node_14 = new TreeNode(14);
    final TreeNode node_9 = new TreeNode(9);
    node_9.left = new TreeNode(5);
    node_9.right = new TreeNode(12);
    node_9.right.left = node_11;
    node_9.right.right = node_14;
    final TreeNode node_20 = new TreeNode(20);
    node_20.left = node_9;
    node_20.right = new TreeNode(25);
//    TreeNode actual = findInorderSuccessorTree(node_20, node_9);
//    assert node_11 == actual;
    TreeNode actual = s.inorderSuccessor(node_20, node_14);
    assert node_20 == actual;
  }
}
