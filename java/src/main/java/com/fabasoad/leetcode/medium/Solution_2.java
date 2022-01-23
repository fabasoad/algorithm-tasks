package com.fabasoad.leetcode.medium;

public class Solution_2 {

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int delta = 0;
    ListNode head = null;
    ListNode node = null;
    while (l1 != null || l2 != null) {
      int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + delta;
      if (val > 9) {
        val %= 10;
        delta = 1;
      } else {
        delta = 0;
      }
      final ListNode n = new ListNode(val);
      if (head == null) {
        node = head = n;
      } else {
        node.next = n;
        node = n;
      }
      l1 = l1 == null ? null : l1.next;
      l2 = l2 == null ? null : l2.next;
    }
    if (delta > 0) {
      node.next = new ListNode(delta);
    }
    return head;
  }

  public static void main(String[] args) {
    final Solution_2 s = new Solution_2();
    ListNode res = s.addTwoNumbers(
        new ListNode(2, new ListNode(4, new ListNode(3))),
        new ListNode(5, new ListNode(6, new ListNode(4))));
    System.out.println(res);
    res = s.addTwoNumbers(
        new ListNode(4, new ListNode(4, new ListNode(6))),
        new ListNode(5, new ListNode(6, new ListNode(4))));
    System.out.println(res);
    res = s.addTwoNumbers(
        new ListNode(4, new ListNode(4, new ListNode(6))),
        new ListNode(5));
    System.out.println(res);
    res = s.addTwoNumbers(
        new ListNode(4),
        new ListNode(5, new ListNode(6, new ListNode(4))));
    System.out.println(res);
    res = s.addTwoNumbers(
        new ListNode(9),
        new ListNode(5, new ListNode(9, new ListNode(9))));
    System.out.println(res);
    res = s.addTwoNumbers(
        new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))),
        new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
    System.out.println(res);
  }
}
