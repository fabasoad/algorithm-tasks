package com.fabasoad.kickstart;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KS3_P1 {
  // Object for Input
  static Scanner inputObject = new Scanner(System.in);

  public static void main(String args[]) {
    // Declare integer 'T' (Number of Test Cases)
    int T;
    // & read it from Standard Input
    T = inputObject.nextInt();
    // Loop through the number of Test Cases [1, T]
    final Map<Integer, Integer> result = new HashMap<>();
    for (int test_case = 1; test_case <= T; ++test_case) {
      // Call the 'solve()' function to answer each test
      result.put(test_case, solve());
    }
    for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
      System.out.println("Case #" + entry.getKey() + ": " + entry.getValue());
    }
    // Close the Object for Input
    inputObject.close();
  }

  static int solve() {
    // Declare the integers N (Number of Boxes) & M (Number of Kids)
    int N, M;
    // Read Integers N & M from Standard Input
    N = inputObject.nextInt();
    M = inputObject.nextInt();
    // Declare an array 'C' (Candies) of size 'N'
    int[] C = new int[N];
    // Read the array 'C' from Standard Input
    for (int i = 0; i < N; ++i) {
      C[i] = inputObject.nextInt();
    }
    // Declare integer 'totalCandies' to store the overall count of Candies in all boxes
    int totalCandies = 0;
    // Calculate the sum (totalCandies) by iterating through array 'C'
    for (int i = 0; i < N; ++i) {
      totalCandies += C[i];
    }
    // Every Kid will get 'floor(totalCandies / M)' Candies
    // Hence, Left Out Candies will be (totalCandies % M).
    return totalCandies % M;
  }
}

