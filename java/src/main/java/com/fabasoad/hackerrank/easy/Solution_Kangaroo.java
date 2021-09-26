package com.fabasoad.hackerrank.easy;

/**
 * https://www.hackerrank.com/challenges/kangaroo/problem
 */
public class Solution_Kangaroo {

    public static void main(String[] args) {
        System.out.println(kangaroo(0, 2, 5, 3));
    }

    private static String kangaroo(int x1, int v1, int x2, int v2) {
        int[] a = x1 > x2 ? new int[] { x1, v1 } : new int[] { x2, v2 };
        int[] b = x1 > x2 ? new int[] { x2, v2 } : new int[] { x1, v1 };
        String answer = "NO";
        while (true) {
            if (a[0] == b[0]) {
                answer = "YES";
                break;
            }
            if (a[0] < b[0]) {
                break;
            }
            a[0] += a[1];
            b[0] += b[1];
        }
        return answer;
    }
}
