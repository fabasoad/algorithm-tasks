package com.fabasoad.leetcode.medium;

public class Solution_1381 {

  static class CustomStack {

    private static class Node {
      int val;
      Node prev;
      Node next;
      Node(int val) {
        this.val = val;
      }
    }

    private final int maxSize;
    private int size;
    private Node head;
    private Node tail;

    public CustomStack(int maxSize) {
      this.maxSize = maxSize;
    }

    public void push(int x) {
      if (size == maxSize) {
        return;
      }
      final Node node = new Node(x);
      if (tail == null) {
        head = tail = node;
      } else {
        tail.next = node;
        node.prev = tail;
        tail = tail.next;
      }
      size++;
    }

    public int pop() {
      if (tail == null) {
        return -1;
      } else {
        int res = tail.val;
        if (tail.prev == null) {
          head = tail = null;
        } else {
          tail = tail.prev;
          tail.next = null;
        }
        size--;
        return res;
      }
    }

    public void increment(int k, int val) {
      int c = k;
      Node n = head;
      while (n != null && c > 0) {
        n.val += val;
        n = n.next;
        c--;
      }
    }
  }

  public static void main(String[] args) {
    final var stack = new CustomStack(3);
    stack.push(1);
    stack.push(2);
    assert 2 == stack.pop();
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.increment(5, 100);
    stack.increment(2, 100);
    assert 103 == stack.pop();
    assert 202 == stack.pop();
    assert 201 == stack.pop();
    assert -1 == stack.pop();
  }
}
