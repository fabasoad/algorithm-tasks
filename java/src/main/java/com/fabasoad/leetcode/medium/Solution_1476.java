package com.fabasoad.leetcode.medium;

public class Solution_1476 {

  public static void main(String[] args) {
    final var rec = new SubrectangleQueries(new int[][] {
        { 1, 2, 1 },
        { 4, 3, 4 },
        { 3, 2, 1 },
        { 1, 1, 1 }
    });
    assert 1 == rec.getValue(0, 2);
    rec.updateSubrectangle(0, 0, 3, 2, 5);
    assert 5 == rec.getValue(0, 2);
    assert 5 == rec.getValue(3, 1);
    rec.updateSubrectangle(3, 0, 3, 2, 10);
    assert 10 == rec.getValue(3, 1);
    assert 5 == rec.getValue(0, 2);
  }

  static class SubrectangleQueries {

    final int[][] rec;

    public SubrectangleQueries(int[][] rectangle) {
      rec = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
      for (int i = row1; i <= row2; i++) {
        for (int j = col1; j <= col2; j++) {
          rec[i][j] = newValue;
        }
      }
    }

    public int getValue(int row, int col) {
      return rec[row][col];
    }
  }
}
