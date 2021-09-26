package com.fabasoad.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution_PascalsTriangle2 {

  public static void main(String[] args) {
    List<Integer> actual = getRow(3);
    actual = getRow(0);
    actual = getRow(1);
  }

  public static List<Integer> getRow(int rowIndex) {
    if (rowIndex == 0) return List.of(1);
    List<Integer> last = List.of(1, 1);
    if (rowIndex == 1) return last;
    int row = 2;
    while (row <= rowIndex) {
      final List<Integer> curr = new ArrayList<>();
      curr.add(1);
      for (int i = 1; i < last.size(); i++) {
        curr.add(last.get(i - 1) + last.get(i));
      }
      curr.add(1);
      last = curr;
      row++;
    }
    return last;
  }
}
