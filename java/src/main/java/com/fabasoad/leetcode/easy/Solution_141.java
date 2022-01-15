package com.fabasoad.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class Solution_141 {

  static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public boolean hasCycle(ListNode head) {
    ListNode node = head;
    Set<ListNode> visited = new HashSet<>();
    while (node != null) {
      if (visited.contains(node)) {
        return true;
      }
      visited.add(node);
      node = node.next;
    }
    return false;
  }
}
