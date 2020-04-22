package io.github.fabasoad.hackerrank.easy;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

/**
 * https://www.hackerrank.com/challenges/bon-appetit/problem
 */
public class Solution_BonAppetit {

    public static void main(String[] args) {
        bonAppetit(asList(3, 10, 2, 9), 1, 12);
        bonAppetit(asList(3, 10, 2, 9), 1, 7);
    }

    static void bonAppetit(List<Integer> bill, int k, int b) {
        final int res = IntStream.range(0, bill.size()).filter(i -> i != k).map(bill::get).sum() / 2;
        System.out.println(res == b ? "Bon Appetit" : b - res);
    }
}
