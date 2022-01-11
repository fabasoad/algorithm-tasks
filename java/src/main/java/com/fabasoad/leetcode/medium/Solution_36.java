package com.fabasoad.leetcode.medium;

import java.util.function.BiFunction;

public class Solution_36 {

  public static void main(String[] args) {
    assert isValidSudoku(new char[][] {
        {'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}
    });
    assert !isValidSudoku(new char[][] {
        {'8','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}
    });
  }

  private static boolean x3_3(char[][] board, int x, int y /* left-upper corner */) {
    final boolean[] cells = new boolean[9];
    for (int i = x; i < x + 3; i++) {
      for (int j = y; j < y + 3; j++) {
        final char cell = board[i][j];
        if (cell == '.') {
          continue;
        }
        final int index = Integer.parseInt(String.valueOf(cell)) - 1;
        if (cells[index]) {
          return false;
        }
        cells[index] = true;
      }
    }
    return true;
  }

  private static boolean x3_3(char[][] board) {
    for (int i = 0; i < 9; i += 3) {
      for (int j = 0; j < 9; j += 3) {
        if (!x3_3(board, i, j)) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean line(char[][] board, BiFunction<Integer, Integer, Character> getCell) {
    for (int i = 0; i < board.length; i++) {
      final boolean[] cells = new boolean[9];
      for (int j = 0; j < board[i].length; j++) {
        final char cell = getCell.apply(i, j);
        if (cell == '.') {
          continue;
        }
        final int index = Integer.parseInt(String.valueOf(cell)) - 1;
        if (cells[index]) {
          return false;
        }
        cells[index] = true;
      }
    }
    return true;
  }

  private static boolean horizontal(char[][] board) {
    return line(board, (x, y) -> board[x][y]);
  }

  private static boolean vertical(char[][] board) {
    return line(board, (x, y) -> board[y][x]);
  }

  public static boolean isValidSudoku(char[][] board) {
    return horizontal(board) && vertical(board) && x3_3(board);
  }
}
