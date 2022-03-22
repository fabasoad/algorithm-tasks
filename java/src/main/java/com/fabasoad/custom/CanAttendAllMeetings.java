package com.fabasoad.custom;

import java.util.Arrays;
import java.util.Comparator;

class CanAttendAllMeetings {

  // whole meeting. no overlap.
  private static boolean canAttend(int[][] meetings) {
    Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
    for (int i = 0; i < meetings.length - 1; i++) {
      if (meetings[i][1] > meetings[i + 1][0]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(canAttend(new int[][] {{1,2},{5,9},{2,5}}));
    System.out.println(canAttend(new int[][] {{5,9},{2,6},{1,2}}));
    System.out.println(canAttend(new int[0][]));
    System.out.println(canAttend(new int[][] {{-2,-1},{4,10},{2,3}}));
  }
}
