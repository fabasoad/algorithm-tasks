package com.fabasoad.custom;

import java.util.Arrays;
import java.util.PriorityQueue;

class ThirdSmallest {

  public static int smallest3(int[] nums) {
    return smallest(nums, 3);
  }

  public static int smallest(int[] nums, int num) {
    if (nums.length < num) {
      return -1;
    }
    final PriorityQueue<Integer> queue = new PriorityQueue<>();
    Arrays.stream(nums).forEach(queue::add);
    int res = queue.poll();
    while (num - 1 > 0) {
      res = queue.poll();
      num--;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(smallest3(new int[] {1}));
    System.out.println(smallest3(new int[0]));
    System.out.println(smallest3(new int[] {4, 2, -9}));
    System.out.println(smallest3(new int[] {49, 8, 23, -2, -3, -3}));
  }
}
