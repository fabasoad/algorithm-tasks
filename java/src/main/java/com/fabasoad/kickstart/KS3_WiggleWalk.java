package com.fabasoad.kickstart;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class KS3_WiggleWalk {

  private static int[] endPosition(int N, int R, int C, int Sr, int Sc, String instructions) {
    final Map<Integer, Set<Integer>> map = new HashMap<>();
    map.put(Sr, new HashSet<>());
    map.get(Sr).add(Sc);
    int moveIndex = 0;
    while (moveIndex < instructions.length()) {
      while (map.get(Sr).contains(Sc)) {
        switch (instructions.charAt(moveIndex)) {
          case 'E':
            Sc++;
            break;
          case 'W':
            Sc--;
            break;
          case 'S':
            Sr++;
            break;
          case 'N':
            Sr--;
            break;
        }
        map.putIfAbsent(Sr, new HashSet<>());
      }
      moveIndex++;
      map.get(Sr).add(Sc);
    }
    return new int[] {Sr, Sc};
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
