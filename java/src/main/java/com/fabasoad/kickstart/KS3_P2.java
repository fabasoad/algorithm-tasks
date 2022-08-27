package com.fabasoad.kickstart;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KS3_P2 {

  public static void main(String args[]) {
    try (Scanner inputObject = new Scanner(System.in)) {
      int numberOfTestCases = inputObject.nextInt();
      final Map<Integer, Integer> result = new HashMap<>();
      for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
        int numberOfDays = inputObject.nextInt();
        // Declare an array 'C' (Candies) of size 'N'
        int[] visitors = new int[numberOfDays + 1];
        // Read the array 'C' from Standard Input
        for (int i = 0; i < numberOfDays; ++i) {
          visitors[i] = inputObject.nextInt();
        }
        visitors[visitors.length - 1] = -1;
        result.put(testCase, solve(visitors));
      }
      for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
        System.out.println("Case #" + entry.getKey() + ": " + entry.getValue());
      }
    }
  }

  static int solve(int[] visitors) {
    int breakingDays = 0;
    int max = -1;
    for (int i = 0; i < visitors.length - 1; i++) {
      if (visitors[i] > max) {
        max = visitors[i];
        if (visitors[i] > visitors[i + 1]) {
          breakingDays++;
        }
      }
    }

    return breakingDays;
  }
}

