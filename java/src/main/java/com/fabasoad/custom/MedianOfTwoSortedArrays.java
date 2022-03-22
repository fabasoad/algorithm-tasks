package com.fabasoad.custom;

class MedianOfTwoSortedArrays {

  private static void fill(int[] a, int a1, int[] b, int b1) {
    while (a1 < a.length) {
      b[b1++] = a[a1++];
    }
  }

  private static double median(int[] a, int[] b) {
    if (a.length == 0 && b.length == 0) {
      return .0;
    }
    int[] merged = new int[a.length + b.length];
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < a.length && j < b.length) {
      if (a[i] < b[j]) {
        merged[k] = a[i];
        i++;
      } else {
        merged[k] = b[j];
        j++;
      }
      k++;
    }
    fill(a, i, merged, k);
    fill(b, j, merged, k);
    int mid = merged.length / 2;
    return merged.length % 2 == 0
      ? (double) (merged[mid - 1] + merged[mid]) / 2
      : merged[mid];
  }

  public static void main(String[] args) {
    System.out.println(median(new int[0], new int[] { 1 }));
    System.out.println(median(new int[] { 1 }, new int[0]));
    System.out.println(median(new int[] { 2 }, new int[] { 1 }));
    System.out.println(median(new int[0], new int[0]));
    System.out.println(median(new int[] { 4, 5, 9 }, new int[] { 1, 6, 8 }));
    System.out.println(median(new int[] { 1, 4 }, new int[] { 2 }));
  }
}
