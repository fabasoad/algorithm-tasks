package com.fabasoad.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution_856 {

  public static void main(String[] args) {
    assert 1 == scoreOfParentheses("()");
    assert 2 == scoreOfParentheses("(())");
    assert 2 == scoreOfParentheses("()()");
    assert 12 == scoreOfParentheses("((()(())))");
  }

  private static class TreeNode {
    final int val = 1;
    List<TreeNode> children = new ArrayList<>();
    TreeNode parent;
    TreeNode(TreeNode parent) { this.parent = parent; }
    TreeNode addChild() {
      final TreeNode node = new TreeNode(this);
      children.add(node);
      return node;
    }
    int score() {
      return children.size() == 0
          ? this.val
          : 2 * children.stream().mapToInt(TreeNode::score).sum();
    }
  }

  public static int scoreOfParentheses(String s) {
    final char left = '(';

    int score = 0;
    TreeNode node = null;
    for (int i = 0; i < s.length(); i++) {
      final char c = s.charAt(i);
      if (c == left) {
        if (node == null) {
          node = new TreeNode(null);
        } else {
          node = node.addChild();
        }
      } else if (node != null) {
        if (node.parent == null) {
          score += node.score();
        }
        node = node.parent;
      }
    }

    return score;
  }
}
