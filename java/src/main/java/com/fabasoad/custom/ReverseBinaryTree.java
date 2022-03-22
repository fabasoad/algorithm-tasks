package com.fabasoad.custom;

class ReverseBinaryTree {
  private static class Node<T> {
    T val;
    Node<T> left;
    Node<T> right;
    Node(T val) {
      this.val = val;
    }
    Node(T val, Node<T> left, Node<T> right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static void reverseBinaryTree(Node<Integer> node) {
    if (node == null) {
      return;
    }
    Node<Integer> n = node.left;
    node.left = node.right;
    node.right = n;
    reverseBinaryTree(node.left);
    reverseBinaryTree(node.right);
  }

  public static void main(String[] args) {
    //          4
    //       1     2
    //    3
    final var node4 = new Node<Integer>(3);
    final var node3 = new Node<Integer>(2);
    final var node2 = new Node<Integer>(1, node4, null);
    final var node1 = new Node<Integer>(4, node2, node3);
    reverseBinaryTree(node1);
    assert node1.val == 4;
    assert node1.left != null;
    assert node1.right != null;
    assert node1.left.val == 2;
    assert node1.right.val == 1;
    assert node1.left.left == null;
    assert node1.left.right == null;
    assert node1.right.left == null;
    assert node1.right.right != null;
    assert node1.right.right.val == 3;
    assert node1.right.right.right == null;
    assert node1.right.right.left == null;
  }
}
