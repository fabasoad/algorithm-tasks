package com.fabasoad.leetcode.medium;

public class Solution_622 {

  static class MyCircularQueue {

    static class Node {
      int val;
      Node prev;
      Node next;
      Node(int val) {
        this.val = val;
      }
    }

    private final int maxSize;
    private int currSize;
    private Node head;
    private Node tail;

    public MyCircularQueue(int k) {
      this.maxSize = k;
    }

    public boolean enQueue(int value) {
      if (maxSize <= currSize) {
        return false;
      }
      final Node n = new Node(value);
      if (head == null) {
        head = this.tail = n;
      } else {
        n.next = tail;
        tail.prev = n;
        tail = n;
      }
      currSize++;
      return true;
    }

    public boolean deQueue() {
      if (currSize == 0) {
        return false;
      }
      currSize--;
      Node n = head.prev;
      if (n != null) {
        n.next = null;
      }
      head = n;
      return true;
    }

    public int Front() {
      return currSize == 0 ? -1 : head.val;
    }

    public int Rear() {
      return currSize == 0 ? -1 : tail.val;
    }

    public boolean isEmpty() {
      return currSize == 0;
    }

    public boolean isFull() {
      return currSize == maxSize;
    }
  }

  public static void main(String[] args) {
    // case 1
    System.out.println("-- Case 1 --");
    final MyCircularQueue queue1 = new MyCircularQueue(3);
    System.out.println(queue1.enQueue(1));
    System.out.println(queue1.enQueue(2));
    System.out.println(queue1.enQueue(3));
    System.out.println(queue1.enQueue(4));
    System.out.println(queue1.Rear());
    System.out.println(queue1.isFull());
    System.out.println(queue1.deQueue());
    System.out.println(queue1.enQueue(4));
    System.out.println(queue1.Rear());
    // case 2
    System.out.println("-- Case 2 --");
    final MyCircularQueue queue2 = new MyCircularQueue(6);
    System.out.println(queue2.enQueue(6));
    System.out.println(queue2.Rear());
    System.out.println(queue2.Rear());
    System.out.println(queue2.deQueue());
    System.out.println(queue2.enQueue(5));
    System.out.println(queue2.Rear());
    System.out.println(queue2.deQueue());
    System.out.println(queue2.Front());
    System.out.println(queue2.deQueue());
    System.out.println(queue2.deQueue());
    System.out.println(queue2.deQueue());
  }
}
