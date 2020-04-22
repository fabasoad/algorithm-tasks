package io.github.fabasoad.hackerrank.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import static java.util.Arrays.asList;

/**
 * https://www.hackerrank.com/challenges/count-triplets-1/problem
 */
public class Solution_CountTriplets {

    public static void main(String[] args) {
        assert 2 == countTriplets(asList(1L, 2L, 2L, 4L), 2L);
        assert 6 == countTriplets(asList(1L, 3L, 9L, 9L, 27L, 81L), 3L);
        assert 4 == countTriplets(asList(1L, 5L, 5L, 25L, 125L), 5L);
    }

    static BiFunction<Long,Long,Long> increasing(final long amount) {
        return (key, value) -> value == null ? amount : value + amount;
    }

    static long countTriplets(List<Long> arr, long r){
        Map<Long,Long> v2 = new HashMap<>();
        Map<Long,Long> v3 = new HashMap<>();
        long count = 0L;
        for (Long k : arr) {
            count += v3.getOrDefault(k, 0L);
            if (v2.get(k) != null) {
                v3.compute(k * r, increasing(v2.get(k)));
            }
            v2.compute(k * r, increasing(1));
        }
        return count;
    }
}
