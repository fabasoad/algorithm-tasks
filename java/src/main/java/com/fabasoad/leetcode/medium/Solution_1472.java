package com.fabasoad.leetcode.medium;

class Solution_1472 {
  
  static class BrowserHistory {
    
    static class Node<T> {
      T val;
      Node<T> prev;
      Node<T> next;
      Node(T val) {
        this.val = val;
      }
    }

    private Node<String> curr;

    public BrowserHistory(String homepage) {
      curr = new Node<>(homepage);
    }
    
    public void visit(String url) {
      final Node<String> node = new Node<>(url);
      node.prev = curr;
      curr.next = node;
      curr = node;
    }
    
    public String back(int steps) {
      while (steps > 0 && curr.prev != null) {
        curr = curr.prev;
        steps--;
      }
      return curr.val;
    }
    
    public String forward(int steps) {
      while (steps > 0 && curr.next != null) {
        curr = curr.next;
        steps--;
      }
      return curr.val;
    }
  }

  public static void main(String[] args) {
    final BrowserHistory b = new BrowserHistory("leetcode.com");
    b.visit("google.com");
    b.visit("facebook.com");
    b.visit("youtube.com");
    System.out.println(b.back(1));
    System.out.println(b.back(1));
    System.out.println(b.forward(1));
    b.visit("linkedin.com");
    System.out.println(b.forward(2));
    System.out.println(b.back(2));
    System.out.println(b.back(7));
  }
}
