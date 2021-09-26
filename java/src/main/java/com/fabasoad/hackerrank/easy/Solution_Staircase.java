package com.fabasoad.hackerrank.easy;

/**
 * https://www.hackerrank.com/challenges/staircase/problem
 */
public class Solution_Staircase {

    public static void main(String[] args) {
        staircase(5);
    }
    static void staircase(int n) {
        for (int i = 1; i <= n; i++) {
            String spaces = i == n ? "" : String.format("%0" + (n - i) + "d", 0).replace("0", " ");
            System.out.println(
                spaces +
                String.format("%0" + i + "d", 0).replace("0", "#")
            );
        }
    }
}
