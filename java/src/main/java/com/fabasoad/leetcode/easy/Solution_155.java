package com.fabasoad.leetcode.easy;

class MinStack {

  static class Node {
    int val;
    Node next;
    Node prev;
  }

  int min;
  Node head;

  public MinStack() {
    min = Integer.MAX_VALUE;
    head = null;
  }

  public void push(int val) {
    final Node node = new Node();
    node.val = val;
    if (head == null) {
      head = node;
      min = node.val;
    } else {
      head.next = node;
      node.prev = head;
      if (val < min) {
        min = val;
      }
      head = node;
    }
  }

  public void pop() {
    if (head.val == min) {
      Node n = head.prev;
      min = Integer.MAX_VALUE;
      while (n != null) {
        if (n.val < min) {
          min = n.val;
        }
        n = n.prev;
      }
    }
    head = head.prev;
  }

  public int top() {
    return head.val;
  }

  public int getMin() {
    return min;
  }
}

public class Solution_155 {
  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    assert -3 == minStack.getMin(); // return -3
    minStack.pop();
    assert 0 == minStack.top();    // return 0
    assert -2 == minStack.getMin(); // return -2
  }
}
