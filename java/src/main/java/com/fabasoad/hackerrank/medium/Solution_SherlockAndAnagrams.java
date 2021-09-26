package com.fabasoad.hackerrank.medium;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 */
public class Solution_SherlockAndAnagrams {

    public static void main(String[] args) {
        assert 4 == sherlockAndAnagrams("abba");
        assert 0 == sherlockAndAnagrams("abcd");
        assert 3 == sherlockAndAnagrams("ifailuhkqq");
        assert 10 == sherlockAndAnagrams("kkkk");
        assert 5 == sherlockAndAnagrams("cdcd");
    }

    static int sherlockAndAnagrams(String s) {
        int count = 0;
        for (int pos = 0; pos < s.length(); pos++) {
            for (int substrIndex = pos + 1; substrIndex <= s.length(); substrIndex++) {
                for (int pos2 = pos + 1; pos2 + substrIndex - pos <= s.length(); pos2++) {
                    char[] sorted1 = s.substring(pos, substrIndex).toCharArray();
                    char[] sorted2 = s.substring(pos2, pos2 + substrIndex - pos).toCharArray();
                    Arrays.sort(sorted1);
                    Arrays.sort(sorted2);
                    if (Arrays.equals(sorted1, sorted2)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
