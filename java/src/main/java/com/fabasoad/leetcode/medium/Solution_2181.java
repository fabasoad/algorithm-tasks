package com.fabasoad.leetcode.medium;

public class Solution_2181 {

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode mergeNodes(ListNode head) {
    ListNode node = head;
    ListNode result = null;
    ListNode resultIter = null;
    int sum = 0;
    while (node != null) {
      if (node.val != 0) {
        sum += node.val;
      } else if (sum > 0) {
        ListNode n = new ListNode(sum);
        sum = 0;
        if (resultIter == null) {
          resultIter = n;
          result = n;
        } else {
          resultIter.next = n;
          resultIter = resultIter.next;
        }
      }
      node = node.next;
    }
    return result;
  }
}
