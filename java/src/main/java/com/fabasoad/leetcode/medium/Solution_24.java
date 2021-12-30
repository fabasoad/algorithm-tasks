package com.fabasoad.leetcode.medium;

import com.fabasoad.leetcode.easy.Solution_206;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_24 {

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static void main(String[] args) {
    assert 2 == swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))).val;
    assert 1 == swapPairs(new ListNode(1)).val;
    assert 2 == swapPairs(new ListNode(1, new ListNode(2))).val;
  }

  public static ListNode swapPairs(ListNode head) {
    Queue<ListNode> queue1 = new ArrayDeque<>();
    Queue<ListNode> queue2 = new ArrayDeque<>();
    ListNode node = head;
    boolean flag = true;
    while (node != null) {
      (flag ? queue1 : queue2).add(node);
      flag = !flag;
      node = node.next;
    }
    if (queue2.isEmpty()) {
      return queue1.isEmpty() ? null : queue1.poll();
    }
    ListNode n = queue2.poll();
    ListNode newHead = n;
    flag = true;
    Queue<ListNode> q = queue1;
    while (!q.isEmpty()) {
      ListNode x = q.poll();
      n.next = x;
      n = x;
      q = flag ? queue2 : queue1;
      flag = !flag;
    }
    while (!queue1.isEmpty()) {
      n.next = queue1.poll();
      n = n.next;
    }
    while (!queue2.isEmpty()) {
      n.next = queue2.poll();
      n = n.next;
    }
    n.next = null;
    return newHead;
  }
}
