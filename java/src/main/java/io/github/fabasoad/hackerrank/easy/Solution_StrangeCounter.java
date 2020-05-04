package io.github.fabasoad.hackerrank.easy;

/**
 * https://www.hackerrank.com/challenges/strange-code/problem
 */
public class Solution_StrangeCounter {

    public static void main(String[] args) {
        assert 6L == strangeCounter(4L);
        assert 534L == strangeCounter(1000L);
    }

    static long strangeCounter(long t) {
        long next = 3;
        long t2 = 3;
        while (t2 < t) {
            next *= 2;
            t2 += next;
        }
        return t2 - t + 1;
    }
}
