package com.fabasoad.leetcode.medium;

import java.util.List;

public class Solution_92 {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static ListNode findNode(ListNode head, int pos, int goal) {
        ListNode node = head;
        while (pos < goal - 1) {
            node = node.next;
            pos++;
        }
        return node;
    }

    private static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode n1 = null;
        ListNode from;
        if (left == 1) {
            from = head;
        } else {
            n1 = findNode(head, 1, left);
            from = n1.next;
            n1.next = null;
        }
        ListNode n2 = findNode(from, left, right + 1);
        ListNode tail = n2.next;
        n2.next = null;
        ListNode res = reverse(from);
        if (n1 != null) {
            n1.next = res;
        } else {
            head = res;
        }
        from.next = tail;
        return head;
    }

    public static void main(String[] args) {
        final var s = new Solution_92();
        final var head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        final var head2 = new ListNode(3, new ListNode(5));
        final var head3 = new ListNode(3, new ListNode(5, new ListNode(1)));
        ListNode res = s.reverseBetween(head3, 2, 3);
        System.out.println(res.val);
    }
}
