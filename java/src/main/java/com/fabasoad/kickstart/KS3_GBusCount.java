package com.fabasoad.kickstart;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class KS3_GBusCount {
  private static class GBusComparator implements Comparator<AbstractMap.SimpleImmutableEntry<Integer, Integer>> {

    @Override
    public int compare(AbstractMap.SimpleImmutableEntry<Integer, Integer> o1, AbstractMap.SimpleImmutableEntry<Integer, Integer> o2) {
      return o1.getKey() < o2.getKey()
          ? -1
          : (o1.getKey() > o2.getKey()
            ? 1
            : Integer.compare(o1.getValue(), o2.getValue()));
    }

    @Override
    public boolean equals(Object obj) {
      return false;
    }
  }

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      // Read the number of test cases.
      int t = scanner.nextInt();
      for (int caseIndex = 1; caseIndex <= t; caseIndex++) {
        // Read the GBus specifications.
        int n = scanner.nextInt();
        final Set<AbstractMap.SimpleImmutableEntry<Integer, Integer>> set = new TreeSet<>(new GBusComparator());
        for (int i = 0; i < n; i++) {
          set.add(new AbstractMap.SimpleImmutableEntry<>(scanner.nextInt(), scanner.nextInt()));
        }
        // Read the city set P.
        int p = scanner.nextInt();
        int[] cities = new int[p];
        for (int i = 0; i < p; i++) {
          cities[i] = scanner.nextInt();
        }
        // Solve the test case.
        int[] counts = countBuses(set, cities);
        // Format the output.
        final StringBuilder sb = new StringBuilder();
        for (int count : counts) {
          sb.append(" ").append(count);
        }
        System.out.println("Case #" + caseIndex + ":" + sb);
      }
    }
  }

  static int[] countBuses(Set<AbstractMap.SimpleImmutableEntry<Integer, Integer>> set, int[] cities) {
    final int[] result = new int[cities.length];
    for (int i = 0; i < cities.length; i++) {
      for (AbstractMap.SimpleImmutableEntry<Integer, Integer> entry : set) {
        if (cities[i] >= entry.getKey()) {
          if (cities[i] <= entry.getValue()) {
            result[i]++;
          }
          continue;
        }
        if (cities[i] > entry.getValue()) {
          break;
        }
      }
    }
    return result;
  }
}
