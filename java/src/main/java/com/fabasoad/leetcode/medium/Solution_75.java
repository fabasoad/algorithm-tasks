package com.fabasoad.leetcode.medium;

import java.util.Arrays;

class Solution_75 {

  private static void swap(int[] arr, int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }

  private static void heapify(int[] arr, int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && arr[l] > arr[largest]) {
      largest = l;
    }

    if (r < n && arr[r] > arr[largest]) {
      largest = r;
    }

    if (largest != i) {
      swap(arr, i, largest);
      heapify(arr, n, largest);
    }
  }

  public void sortColors(int[] nums) {
    int n = nums.length;

    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(nums, n, i);
    }

    for (int i = n - 1; i > 0; i--) {
      swap(nums, 0, i);
      heapify(nums, i, 0);
    }
  }

  public static void main(String[] args) {
    final Solution_75 s = new Solution_75();
    final int[] input = { 2,0,2,1,1,0 };
    s.sortColors(input);
    System.out.println(Arrays.toString(input));
  }
}