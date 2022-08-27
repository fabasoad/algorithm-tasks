package com.fabasoad.kickstart;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class KS3_P3 {

  private static AbstractMap.SimpleImmutableEntry<Integer, Integer> newCoords(AbstractMap.SimpleImmutableEntry<Integer, Integer> coords, char direction) {
    return switch (direction) {
      case 'E' -> createTuple(coords.getKey(), coords.getValue() + 1);
      case 'W' -> createTuple(coords.getKey(), coords.getValue() - 1);
      case 'S' -> createTuple(coords.getKey() + 1, coords.getValue());
      case 'N' -> createTuple(coords.getKey() - 1, coords.getValue());
      default -> createTuple(coords.getKey() + 1, coords.getValue() + 1);
    };
  }

  private static AbstractMap.SimpleImmutableEntry<Integer, Integer> createTuple(int r, int c) {
    return new AbstractMap.SimpleImmutableEntry<>(r, c);
  }

  private static AbstractMap.SimpleImmutableEntry<Integer, Integer> move(
      Set<AbstractMap.SimpleImmutableEntry<Integer, Integer>> set,
      int R, int C, int Sr, int Sc, String instructions, int moveIndex) {
    AbstractMap.SimpleImmutableEntry<Integer, Integer> n1 = createTuple(Sr, Sc);
    if (!set.contains(n1)) {
      moveIndex++;
      set.add(n1);
    }
    if (moveIndex == instructions.length()) {
      return n1;
    }
    final AbstractMap.SimpleImmutableEntry<Integer, Integer> n2 = newCoords(n1, instructions.charAt(moveIndex));
    return move(set, R, C, n2.getKey(), n2.getValue(), instructions, moveIndex);
  }

  private static int[] endPosition(int N, int R, int C, int Sr, int Sc, String instructions) {
    final Set<AbstractMap.SimpleImmutableEntry<Integer, Integer>> set = new HashSet<>();
    set.add(createTuple(Sr, Sc));
    final AbstractMap.SimpleImmutableEntry<Integer, Integer> res = move(set, R, C, Sr, Sc, instructions, 0);
    return new int[] { res.getKey(), res.getValue() };
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
