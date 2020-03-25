package io.github.fabasoad.hackerrank;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;

/**
 * https://www.hackerrank.com/challenges/the-birthday-bar/problem
 */
public class Solution_BirthdayChocolate {

    public static void main(String[] args) {
        System.out.println(birthday(singletonList(4), 4, 1));
    }

    static int birthday(List<Integer> s, int d, int m) {
        int[] temp = new int[m];
        int counter = 0;
        int result = 0;
        while (counter < s.size()) {
            int limit = counter + m;
            if (limit > s.size()) {
                break;
            }
            int arrIndex = 0;
            for (int i = counter; i < limit; i++) {
                temp[arrIndex] = s.get(i);
                arrIndex++;
            }
            result = Arrays.stream(temp).sum() == d ? result + 1 : result;
            counter++;
        }
        return result;
    }
}
