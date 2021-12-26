package com.fabasoad.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_404 {

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

  private static class Item {
    TreeNode node;
    boolean isLeft;
    Item(TreeNode node, boolean isLeft) {
      this.node = node;
      this.isLeft = isLeft;
    }
  }

  public static int sumOfLeftLeavesBFS(TreeNode root) {
    Queue<Item> queue = new ArrayDeque<>();
    queue.add(new Item(root, false));
    int sum = 0;
    while (!queue.isEmpty()) {
      final Item item = queue.poll();
      if (item.node != null) {
        if (item.node.left == null && item.node.right == null) {
          if (item.isLeft) {
            sum += item.node.val;
          }
        }
        if (item.node.left != null) {
          queue.add(new Item(item.node.left, true));
        }
        if (item.node.right != null) {
          queue.add(new Item(item.node.right, false));
        }
      }
    }
    return sum;
  }

  public static int sumOfLeftLeavesDFS(TreeNode root) {
    return traverse(root, false, 0);
  }

  private static int traverse(TreeNode node, boolean fromLeft, int sum) {
    if (node == null) {
      return sum;
    }
    if (node.left == null && node.right == null) {
      if (fromLeft) {
        return sum + node.val;
      }
      return sum;
    }
    return traverse(node.left, true, sum) + traverse(node.right, false, sum);
  }
}
