package com.fabasoad.leetcode.easy;

public class Solution_21 {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static void main(String[] args) {
    System.out.println(mergeTwoLists(
        new ListNode(1, new ListNode(2, new ListNode(4))),
        new ListNode(1, new ListNode(3, new ListNode(4)))));
    System.out.println(mergeTwoLists(
        null,
        new ListNode(0)));
    System.out.println(mergeTwoLists(
        new ListNode(-9, new ListNode(3)),
        new ListNode(5, new ListNode(7))));
  }

  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode head = null;
    ListNode node = null;
    while (list1 != null && list2 != null) {
      ListNode n;
      if (list1.val < list2.val) {
        n = list1;
        list1 = list1.next;
      } else {
        n = list2;
        list2 = list2.next;
      }
      if (node != null) {
        node.next = n;
      }
      node = n;
      if (head == null) {
        head = node;
      }
    }
    while (list1 != null) {
      if (node == null) {
        node = list1;
        head = node;
      } else {
        node.next = list1;
        node = node.next;
      }
      list1 = list1.next;
    }
    while (list2 != null) {
      if (node == null) {
        node = list2;
        head = node;
      } else {
        node.next = list2;
        node = node.next;
      }
      list2 = list2.next;
    }
    return head;
  }
}
