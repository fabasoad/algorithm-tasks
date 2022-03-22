package com.fabasoad.custom;

class RemoveIslands {

  private static void cell(
      int[][] land,
      int[][] result,
      boolean[][] visited,
      int i,
      int j) {
    if (i >= 0 && i < land.length && j >= 0 && j < land[i].length && !visited[i][j]) {
      visited[i][j] = true;
      if (land[i][j] == 1) {
        result[i][j] = 1; 
        cell(land, result, visited, i, j + 1);
        cell(land, result, visited, i, j - 1);
        cell(land, result, visited, i + 1, j);
        cell(land, result, visited, i - 1, j);
      }
    }
  }

  public static int[][] removeIslands(int[][] land) {
    final boolean[][] visited = new boolean[land.length][];
    for (int i = 0; i < visited.length; i++) {
      visited[i] = new boolean[land[i].length];
    }

    final int[][] result = new int[land.length][];
    for (int i = 0; i < result.length; i++) {
      result[i] = new int[land[i].length];
    }

    for (int i = 0; i < land.length; i++) {
      for (int j = 0; j < land[i].length; j++) {
        if (i == 0 || i == land.length - 1 || j == 0 || j == land[i].length - 1) {
          cell(land, result, visited, i, j);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    final int[][] land = {
      new int[] {1,0,0,0,0,0},
      new int[] {0,1,0,1,1,1},
      new int[] {0,0,1,0,1,0},
      new int[] {1,1,0,0,1,0},
      new int[] {1,0,1,1,0,0},
      new int[] {1,0,0,0,0,1},
    };
    int[][] actual = removeIslands(land);
    final int[][] expected = {
      new int[] {1,0,0,0,0,0},
      new int[] {0,0,0,1,1,1},
      new int[] {0,0,0,0,1,0},
      new int[] {1,1,0,0,1,0},
      new int[] {1,0,0,0,0,0},
      new int[] {1,0,0,0,0,1},
    };
    assert expected.length == actual.length;
    for (int i = 0; i < expected.length; i++) {
      assert expected[i].length == actual[i].length;
      for (int j = 0; j < expected[i].length; j++) {
        assert expected[i][j] == actual[i][j];
      }
    }
  }
}

