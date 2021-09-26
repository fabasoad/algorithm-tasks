package com.fabasoad.hackerrank.easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * https://www.hackerrank.com/challenges/migratory-birds/problem
 */
public class Solution_MigratoryBirds {

    public static void main(String[] args) {
        System.out.println(migratoryBirds(asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)));
    }

    static int migratoryBirds(List<Integer> arr) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (final Integer type : arr) {
            map.compute(type, (t, v) -> v == null ? 1 : v + 1);
        }
        return map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse(-1);
    }
}
