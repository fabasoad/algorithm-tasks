package com.fabasoad.kickstart;

import java.util.Scanner;

public class KS3_SherlockAndWatsonGymSecrets {

  private static long powerN(long number, int power){
    long res = 1;
    long sq = number;
    while (power > 0) {
      if (power % 2 == 1) {
        res *= sq;
      }
      sq = sq * sq;
      power /= 2;
    }
    return res;
  }

  static long countPairs(int a, int b, long n, int k) {
    long pairs = 0;
    for (long i = 1L; i <= n; i++) {
      for (long j = 1L; j <= n; j++) {
        if (i == j) {
          continue;
        }
        long sprouts1 = powerN(i, a);
        long sprouts2 = powerN(j, b);
        long sproutsTotal = sprouts1 + sprouts2;
        long res = sproutsTotal % k;
        pairs += (res == 0L ? 1L : 0L);
      }
    }
    return pairs % 1000000007L;
  }

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      // Read the number of test cases.
      int testCaseCount = scanner.nextInt();
      for (int caseIndex = 1; caseIndex <= testCaseCount; caseIndex++) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        long n = scanner.nextLong();
        int k = scanner.nextInt();

        long pairs = countPairs(a, b, n, k);
        System.out.println("Case #" + caseIndex + ": " + pairs);
      }
    }
  }
}
