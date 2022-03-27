package com.fabasoad.leetcode.medium;

public class Solution_654 {

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

    @Override
    public String toString() {
      return String.format("%s {%s %s}", this.val, this.left, this.right);
    }
  }

  private static int indexOfMax(int[] nums, int from, int to) {
    int max = Integer.MIN_VALUE;
    int index = -1;
    for (int i = from; i < to; i++) {
      if (nums[i] > max) {
        max = nums[i];
        index = i;
      }
    }
    return index;
  }

  private static void constructMaximumBinaryTree(int[] nums, int from, int to, boolean left, TreeNode parent) {
    final int mid = indexOfMax(nums, from, to);
    if (mid == -1) {
      return;
    }
    final TreeNode node = new TreeNode(nums[mid]);
    if (parent != null) {
      if (left) {
        parent.left = node;
      } else {
        parent.right = node;
      }
    }
    constructMaximumBinaryTree(nums, from, mid, true, node);
    constructMaximumBinaryTree(nums, mid + 1, to, false, node);
  }

  public TreeNode constructMaximumBinaryTree(int[] nums) {
    final int mid = indexOfMax(nums, 0, nums.length);
    if (mid == -1) {
      return null;
    }
    final TreeNode node = new TreeNode(nums[mid]);
    constructMaximumBinaryTree(nums, 0, mid, true, node);
    constructMaximumBinaryTree(nums, mid + 1, nums.length, false, node);
    return node;
  }

  public static void main(String[] args) {
    final Solution_654 s = new Solution_654();
    System.out.println(s.constructMaximumBinaryTree(new int[] { 3,2,1,6,0,5 }));
  }
}
