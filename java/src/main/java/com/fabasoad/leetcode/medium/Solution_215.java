package com.fabasoad.leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_215 {

  public static void main(String[] args) {
    assert 5 == findKthLargest(new int[] { 3,2,1,5,6,4 }, 2);
    assert 4 == findKthLargest(new int[] { 3,2,3,1,2,4,5,5,6 }, 4);
    assert 2 == findKthLargest(new int[] { 3,2 }, 2);
  }

  public static int findKthLargest(int[] nums, int k) {
    final PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    for (final int n : nums) {
      queue.add(n);
    }
    while (k > 1) {
      queue.poll();
      k--;
    }
    return queue.isEmpty() ? -1 : queue.poll();
  }
}
