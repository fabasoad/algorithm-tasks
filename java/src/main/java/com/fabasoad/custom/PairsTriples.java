package com.fabasoad.custom;

import java.util.PriorityQueue;

class PairsTriples {

  private static boolean complete(String hand) {
    if ((hand.length() - 2) % 3 != 0) {
      return false;
    }
    final PriorityQueue<Character> queue = new PriorityQueue<>();
    for (int i = 0; i < hand.length(); i++) {
      queue.add(hand.charAt(i));
    }
    char last = 'A' - 1;
    int count = 0;
    boolean flag = false;
    while (!queue.isEmpty()) {
      final char c = queue.poll();
      if (last == c) {
        if (count == 2) {
          count = 0;
        } else {
          count++;
        }
      } else {
        if (count == 2) {
          if (flag) {
            return false;
          }
          count = 0;
          flag = true;
        } else if (count > 0) {
          return false;
        }
        last = c;
        count++;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    assert complete("11133555");
    assert !complete("111333555");
    assert complete("00000111");
    assert complete("13233121");
    assert !complete("11223344555");
    assert complete("99999999");
    assert !complete("999999999");
  }
}
