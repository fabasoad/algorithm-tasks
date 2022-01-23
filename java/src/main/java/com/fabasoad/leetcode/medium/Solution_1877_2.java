package com.fabasoad.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution_1877_2 {

  private static class Pair {
    private final int left;
    private final int right;

    private Pair(int left, int right) {
      this.left = left;
      this.right = right;
    }

    final int sum() {
      return left + right;
    }

    @Override
    public String toString() {
      return String.format("[%s, %s]", left, right);
    }
  }

  private static class PairList {
    private final List<Pair> pairs;

    private PairList(List<Pair> pairs) {
      this.pairs = new ArrayList<>(pairs);
    }

    final int max() {
      int max = -1;
      for (final Pair pair : pairs) {
        final int sum = pair.sum();
        max = Math.max(max, sum);
      }
      return max;
    }
  }

  private static class PairListTotal {
    private final List<PairList> pairList = new ArrayList<>();

    private PairList min() {
      int min = Integer.MAX_VALUE;
      PairList res = null;
      for (final PairList pl : pairList) {
        final int max = pl.max();
        if (min > max) {
          min = max;
          res = pl;
        }
      }
      return res;
    }

    void add(PairList pl) {
      this.pairList.add(pl);
    }

    int size() { return this.pairList.size(); }
  }

  int prev = 0;

  private void pair(int[] nums, List<Pair> list, PairListTotal total) {
    for (int i = 1; i < nums.length; i++) {
      if (prev != total.size()) {
        for (int j = 0; j < nums.length / 2; j++) {
          list.remove(list.size() - 1);
        }
        prev = total.size();
      }
      list.add(new Pair(nums[0], nums[i]));
      int[] arr = new int[nums.length - 2];
      int x = 0;
      for (int j = 1; j < nums.length; j++) {
        if (j != i) {
          arr[x] = nums[j];
          x++;
        }
      }
      if (arr.length == 0) {
        total.add(new PairList(list));
      } else {
        pair(arr, list, total);
      }
    }
  }

  public int minPairSum(int[] nums) {
    final PairListTotal total = new PairListTotal();
    pair(nums, new ArrayList<>(), total);
    return total.min().max();
  }

  public static void main(String[] args) {
    assert 7 == new Solution_1877_2().minPairSum(new int[] { 3,5,3,2 });
    assert 8 == new Solution_1877_2().minPairSum(new int[] { 3,5,4,2,4,6 });
    assert 6 == new Solution_1877_2().minPairSum(new int[] { 3,2,4,1,1,5,1,3,5,1 });
  }
}
