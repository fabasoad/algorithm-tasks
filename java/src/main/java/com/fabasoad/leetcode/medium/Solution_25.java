package com.fabasoad.leetcode.medium;

public class Solution_25 {

  static class ListNode {
    int val;
    ListNode next;
    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    int i = k;
    ListNode node = head;
    while (node != null && i > 0) {
      node = node.next;
      i--;
    }
    if (node == null && i > 0) {
      return head;
    }
    i = k;
    ListNode prev = null;
    ListNode curr = head;
    while (i > 0) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      i--;
    }
    head.next = reverseKGroup(curr, k);
    return prev;
  }

  private static void printListNode(ListNode node) {
    ListNode n = node;
    while (n != null) {
      System.out.printf("%s -> ", n.val);
      n = n.next;
    }
    System.out.println("null");
  }

  public static void main(String[] args) {
    final Solution_25 s = new Solution_25();
    for (int k : new int[] { 2, 3, 5 }) {
      final ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
      final ListNode node = s.reverseKGroup(head, k);
      printListNode(node);
    }
  }
}
