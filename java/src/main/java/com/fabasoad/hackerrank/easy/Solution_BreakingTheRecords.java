package com.fabasoad.hackerrank.easy;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
 */
public class Solution_BreakingTheRecords {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(breakingRecords(new int[] { 10, 5, 20, 20, 4, 5, 2, 25, 1 })));
    }

    static int[] breakingRecords(int[] scores) {
        int highestScore = scores[0];
        int lowestScore = scores[0];
        int[] counter = new int[2];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > highestScore) {
                highestScore = scores[i];
                counter[0]++;
            }
            if (scores[i] < lowestScore) {
                lowestScore = scores[i];
                counter[1]++;
            }
        }
        return counter;
    }
}
