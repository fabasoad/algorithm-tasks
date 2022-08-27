package com.fabasoad.kickstart;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class KS3_P3 {

  private static int[] newCoords(int r, int c, char direction) {
    switch (direction) {
      case 'E':
        return new int[]{r, c + 1};
      case 'W':
        return new int[]{r, c - 1};
      case 'S':
        return new int[]{r + 1, c};
      case 'N':
        return new int[]{r - 1, c};
      default:
        return new int[]{r + 1, c + 1};
    }
  }

  private static int[] move(
      Map<Integer, Set<Integer>> map, int Sr, int Sc, String instructions, int moveIndex) {
    map.putIfAbsent(Sr, new HashSet<>());
    if (!map.get(Sr).contains(Sc)) {
      moveIndex++;
      map.get(Sr).add(Sc);
    }
    if (moveIndex == instructions.length()) {
      return new int[] {Sr, Sc};
    }
    final int[] n2 = newCoords(Sr, Sc, instructions.charAt(moveIndex));
    return move(map, n2[0], n2[1], instructions, moveIndex);
  }

  private static int[] endPosition(int N, int R, int C, int Sr, int Sc, String instructions) {
    final Map<Integer, Set<Integer>> map = new HashMap<>();
    map.put(Sr, new HashSet<>());
    map.get(Sr).add(Sc);
    return move(map, Sr, Sc, instructions, 0);
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
      for (int t = 1; t <= T; ++t) {
        int N = in.nextInt();
        int R = in.nextInt();
        int C = in.nextInt();
        int Sr = in.nextInt();
        int Sc = in.nextInt();
        String instructions = in.next();
        int[] ans = endPosition(N, R, C, Sr, Sc, instructions);
        System.out.println("Case #" + t + ": " + ans[0] + " " + ans[1]);
      }
    }
  }
}
