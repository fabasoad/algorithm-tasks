package io.github.fabasoad.hackerrank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/plus-minus/problem
 */
public class Solution_PlusMinus {

    public static void main(String[] args) {
        plusMinus(new int[] { 0, 100, 35, 0, 94, 40, 42, 87, 59, 0 });
    }

    static void plusMinus(int[] arr) {
        int countOfZeros = 0;
        int countOfNegatives = 0;
        int countOfPositives = 0;

        List<Integer> data = Arrays.stream(arr).boxed().sorted(Integer::compareTo).collect(Collectors.toList());
        int indexZero = data.lastIndexOf(0);
        if (indexZero < 0) {
            while (data.get(countOfNegatives) < 0) {
                countOfNegatives++;
            }
            countOfPositives = arr.length - countOfNegatives;
        } else {
            countOfPositives = arr.length - indexZero - 1;
            while (indexZero >= 0 && data.get(indexZero) == 0) {
                indexZero--;
            }
            countOfNegatives = indexZero + 1;
            countOfZeros = arr.length - countOfNegatives - countOfPositives;
        }
        System.out.println(BigDecimal.valueOf(countOfPositives).divide(BigDecimal.valueOf(arr.length), 6, RoundingMode.HALF_UP));
        System.out.println(BigDecimal.valueOf(countOfNegatives).divide(BigDecimal.valueOf(arr.length), 6, RoundingMode.HALF_UP));
        System.out.println(BigDecimal.valueOf(countOfZeros).divide(BigDecimal.valueOf(arr.length), 6, RoundingMode.HALF_UP));
    }
}
