package io.github.fabasoad.hackerrank;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class Solution_Triplets {

    public static void main(String[] args) {
        System.out.println(compareTriplets(asList(1, 2 ,3), asList(3, 2, 1)));
    }

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        final int[] r = new int[] { 0, 0 };
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                r[0]++;
            } else if (a.get(i) < b.get(i)) {
                r[1]++;
            }
        }
        return IntStream.of(r).boxed().collect(Collectors.toList());
    }
}
