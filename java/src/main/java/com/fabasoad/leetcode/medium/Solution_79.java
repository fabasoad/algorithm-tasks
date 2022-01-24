package com.fabasoad.leetcode.medium;

public class Solution_79 {

  private static boolean traverse(char[][] board, int x, int y, boolean[][] visited, String word, int ind) {
    if (x >= 0 && x < board.length && y >= 0 && y < board[x].length && !visited[x][y]) {
      final char current = board[x][y];
      if (current == word.charAt(ind)) {
        visited[x][y] = true;
        if (ind + 1 == word.length()) {
          return true;
        }
        return traverse(board, x - 1, y, arrayCopy(visited), word, ind + 1)
            || traverse(board, x + 1, y, arrayCopy(visited), word, ind + 1)
            || traverse(board, x, y - 1, arrayCopy(visited), word, ind + 1)
            || traverse(board, x, y + 1, arrayCopy(visited), word, ind + 1);
      }
    }
    return false;
  }

  private static boolean[][] emptyArray(char[][] board) {
    final boolean[][] visited = new boolean[board.length][];
    for (int j = 0; j < visited.length; j++) {
      visited[j] = new boolean[board[j].length];
    }
    return visited;
  }

  private static boolean[][] arrayCopy(boolean[][] arr) {
    final boolean[][] res = new boolean[arr.length][];
    for (int i = 0; i < res.length; i++) {
      res[i] = new boolean[arr[i].length];
      for (int j = 0; j < arr[i].length; j++) {
        res[i][j] = arr[i][j];
      }
    }
    return res;
  }

  public boolean exist(char[][] board, String word) {
    for (int x = 0; x < board.length; x++) {
      for (int y = 0; y < board[x].length; y++) {
        if (traverse(board, x, y, emptyArray(board), word, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    final Solution_79 s = new Solution_79();
    assert s.exist(new char[][] {
        {'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}
    }, "ABCCED");
    assert s.exist(new char[][] {
        {'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}
    }, "SEE");
    assert !s.exist(new char[][] {
        {'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}
    }, "ABCB");
    assert s.exist(new char[][] {{'A','B'}, {'C','D'}}, "CDBA");
    assert s.exist(new char[][] {
        {'A','B','C','E'}, {'S','F','E','S'}, {'A','D','E','E'}
    }, "ABCESEEEFS");
  }
}
