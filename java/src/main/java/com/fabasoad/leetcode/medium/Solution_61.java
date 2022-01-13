package com.fabasoad.leetcode.medium;

public class Solution_61 {

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static void main(String[] args) {
    final ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    System.out.println(rotateRight(head1, 0).val);
    final ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    System.out.println(rotateRight(head2, 1).val);
    final ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    System.out.println(rotateRight(head3, 2).val);
    final ListNode head4 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    System.out.println(rotateRight(head4, 3).val);
    final ListNode head5 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    System.out.println(rotateRight(head5, 4).val);
    final ListNode head6 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    System.out.println(rotateRight(head6, 5).val);
    System.out.println(rotateRight(null, 1));
  }

  public static ListNode rotateRight(ListNode head, int k) {
    if (k == 0 || head == null) {
      return head;
    }
    int size = 0;
    ListNode node = head;
    while (node != null) {
      node = node.next;
      size++;
    }
    int k1 = k % size;
    if (k1 == 0) {
      return head;
    }
    int c = 0;
    ListNode prev = head;
    node = head;
    while (c < (size - k1)) {
      prev = node;
      node = node.next;
      c++;
    }
    prev.next = null;
    ListNode oldHead = head;
    head = node;
    while (node.next != null) {
      node = node.next;
    }
    node.next = oldHead;
    return head;
  }
}
