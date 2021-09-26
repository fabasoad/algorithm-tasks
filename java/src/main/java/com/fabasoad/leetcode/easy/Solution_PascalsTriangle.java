package com.fabasoad.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution_PascalsTriangle {

  public static void main(String[] args) {
    List<List<Integer>> actual = generate(5);
    actual = generate(1);
  }

  public static List<List<Integer>> generate(int numRows) {
    if (numRows == 1) return List.of(List.of(1));
    final List<List<Integer>> result = new ArrayList<>();
    result.add(List.of(1));
    result.add(List.of(1, 1));
    if (numRows == 2) return result;
    int row = 2;
    while (row < numRows) {
      final List<Integer> curr = new ArrayList<>();
      curr.add(1);
      final List<Integer> last = result.get(result.size() - 1);
      for (int i = 1; i < last.size(); i++) {
        curr.add(last.get(i - 1) + last.get(i));
      }
      curr.add(1);
      result.add(curr);
      row++;
    }
    return result;
  }
}
