package com.fabasoad.leetcode.medium;

public class Solution_19 {

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static void main(String[] args) {
    ListNode head = removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
    System.out.println(head);
    head = removeNthFromEnd(new ListNode(1), 1);
    System.out.println(head);
    head = removeNthFromEnd(new ListNode(1, new ListNode(2)), 2);
    System.out.println(head);
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    int size = 0;
    ListNode node = head;
    while (node != null) {
      node = node.next;
      size++;
    }
    int c = 1;
    ListNode prev = null;
    node = head;
    while (c <= size - n) {
      prev = node;
      node = node.next;
      c++;
    }
    if (prev != null) {
      prev.next = node.next;
      node = head;
    } else {
      node = size > 1 ? head.next : null;
    }
    return node;
  }
}
