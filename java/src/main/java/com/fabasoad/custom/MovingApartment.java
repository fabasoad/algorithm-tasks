package com.fabasoad.custom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MovingApartment {

  private static class ListNode {
    ListNode prev;
    ListNode next;
    Map<String, Boolean> val;
    Map<String, Integer> dist = new HashMap<>();
    ListNode(Map<String, Boolean> val) {
      this.val = val;
    }
    int closest(String key) {
      return closest(key, true, true);
    }
    private int closest(String key, boolean shouldLeft, boolean shouldRight) {
      if (!val.get(key)) {
        if (!dist.containsKey(key)) {
          int left = Integer.MAX_VALUE;
          if (shouldLeft && prev != null) {
            left = prev.closest(key, true, false);
          }
          int right = Integer.MAX_VALUE;
          if (shouldRight && next != null) {
            right = next.closest(key, false, true);
          }
          int d = Math.min(left, right);
          if (d == Integer.MAX_VALUE) {
            return -1;
          } else {
            dist.put(key, d + 1);
          }
        }
        return dist.get(key);
      }
      return 0;
    }
    void addNext(ListNode next) {
      this.next = next;
      next.prev = this;
    }
  }
  
  public int findBlock(List<Map<String, Boolean>> blocks, String[] interest) {
    if (blocks.isEmpty()) {
      return -1;
    }
    final ListNode head = new ListNode(blocks.get(0));
    ListNode node = head;
    for (int i = 1; i < blocks.size(); i++) {
      final ListNode n = new ListNode(blocks.get(i));
      node.addNext(n);
      node = n;
    }
    node = head;
    int total_i = 0;
    int total_min = Integer.MAX_VALUE;
    int result = -1;
    while (node != null) {
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < interest.length; i++) {
        final String word = interest[i];
        int v = node.closest(word);
        max = Math.max(max, v);
      }
      if (max < total_min) {
        total_min = max;
        result = total_i;
      }
      total_i++;
      node = node.next;
    }
    return result;
  }

  public static void main(String[] args) {
    final MovingApartment x = new MovingApartment();
    int actual = x.findBlock(List.of(
        Map.of("g", false, "sc", true, "s", false),
        Map.of("g", true, "sc", false, "s", false),
        Map.of("g", true, "sc", true, "s", false),
        Map.of("g", false, "sc", true, "s", false),
        Map.of("g", false, "sc", true, "s", true)
    ), new String[] { "g", "sc", "s" });
    assert 3 == actual;
  }
}
