package com.fabasoad.custom;

import java.util.Stack;

class ReverseLinkedList {
  private static class Node<T> {
    T val;
    Node<T> next;
    Node(T val) {
      this.val = val;
    }
    Node(T val, Node<T> next) {
      this.val = val;
      this.next = next;
    }
  }

  // stack: 4 1 2 3
  // resultHead: 3
  // node: 3 2 1 4 null
  public static Node<Integer> reverseLinkedList(Node<Integer> head) {
    final var stack = new Stack<Node<Integer>>();
    Node<Integer> node = head;
    while (node != null) {
      stack.add(node);
      node = node.next;
    }
    Node<Integer> resultHead = null;
    while (!stack.isEmpty()) {
      Node<Integer> n = stack.pop();
      if (resultHead == null) {
        resultHead = n;
        node = n;
      } else {
        node.next = n;
        node = node.next;
      }
    }
    if (node != null) {
      node.next = null;
    }
    return resultHead;
  }

  public static void main(String[] args) {
    // 4 -> 1 -> 2 -> 3
    final var node4 = new Node<Integer>(3);
    final var node3 = new Node<Integer>(2, node4);
    final var node2 = new Node<Integer>(1, node3);
    final var node1 = new Node<Integer>(4, node2);
    final Node<Integer> actual = reverseLinkedList(node1);
    assert actual != null;
    assert actual.val == 3;
    assert actual.next != null;
    assert actual.next.val == 2;
    assert actual.next.next != null;
    assert actual.next.next.val == 1;
    assert actual.next.next.next != null;
    assert actual.next.next.next.val == 4;
    assert actual.next.next.next.next == null;
  }
}
