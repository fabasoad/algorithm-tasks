package com.fabasoad.leetcode.easy;

import java.util.Stack;

public class Solution_206 {

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static void main(String[] args) {
    final ListNode node = reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
    assert 5 == node.val;
  }

  public static ListNode reverseList(ListNode head) {
    final Stack<ListNode> stack = new Stack<>();
    ListNode node = head;
    while (node != null) {
      stack.push(node);
      node = node.next;
    }
    ListNode newHead = stack.empty() ? null :stack.pop();
    node = newHead;
    while (node != null) {
      node = node.next = stack.empty() ? null : stack.pop();
    }
    return newHead;
  }
}
