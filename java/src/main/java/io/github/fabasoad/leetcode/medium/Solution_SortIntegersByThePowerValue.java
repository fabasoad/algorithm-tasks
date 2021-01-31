package io.github.fabasoad.leetcode.medium;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.ToIntFunction;

/**
 * https://leetcode.com/problems/sort-integers-by-the-power-value/
 */
public class Solution_SortIntegersByThePowerValue {

  public static void main(String[] args) {
    int actual = getKth(12, 15, 2);
    assert actual == 13;
    actual = getKth(1, 1, 1);
    assert actual == 1;
    actual = getKth(7, 11, 4);
    assert actual == 7;
  }

  public static int getKth(int lo, int hi, int k) {
    final var res = new TreeMap<Integer, Integer>();
    for (int step = lo; step <= hi; step++) {
      res.put(step, 0);
      int x = step;
      while (x != 1) {
        x = convert(x);
        res.merge(step, 1, Integer::sum);
      }
    }
    return getByIndex(k, toSorted(res));
  }

  private static Map<Integer, Integer> toSorted(Map<Integer, Integer> m) {
    final var f = new TreeMap<Integer, Integer>(
        Comparator.comparingInt((ToIntFunction<Integer>) m::get).thenComparingInt(k -> k));
    m.forEach(f::put);
    return f;
  }

  private static int getByIndex(int k, Map<Integer, Integer> m) {
    int index = 0;
    for (final var entry : m.entrySet()) {
      if (k == index + 1) {
        return entry.getKey();
      }
      index++;
    }
    return -1;
  }

  private static int convert(int n) {
    return (n ^ 1) == n + 1 ? n / 2 : 3 * n + 1;
  }
}
