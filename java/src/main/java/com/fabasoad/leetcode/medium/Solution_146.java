package com.fabasoad.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Solution_146 {

  public static void main(String[] args) {
    final var lru = new LRUCache(2);
    lru.put(2, 1);
    lru.put(1, 1);
    lru.put(2, 3);
    lru.put(4, 1);
    int res = lru.get(1);
    System.out.println("Output: " + res);
    res = lru.get(2);
    System.out.println("Output: " + res);
  }
}

class LRUCache {

  static class Node {
    Node prev;
    Node next;
    int key;
    int val;
    Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  final Map<Integer, Node> map = new HashMap<>();
  Node head = new Node(-1, -1);
  Node tail = new Node(-1, -1);
  int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.head.next = this.tail;
    this.tail.prev = this.head;
  }

  private void moveNode(Node node) {
    Node prev = node.prev;
    if (prev != null) {
      prev.next = node.next;
    }
    if (node.next != null) {
      node.next.prev = prev;
    }
    node.prev = head;
    node.next = head.next;
    head.next.prev = node;
    head.next = node;
    if (tail.prev.val == -1) {
      tail.prev = node;
    }
    if (map.size() > this.capacity) {
      Node last = tail.prev;
      tail.prev = last.prev;
      if (last.prev != null) {
        last.prev.next = tail;
      }
      map.remove(last.key);
    }
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      final Node node = map.get(key);
      moveNode(node);
      return node.val;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      map.get(key).val = value;
    } else {
      map.put(key, new Node(key, value));
    }
    moveNode(map.get(key));
  }
}
