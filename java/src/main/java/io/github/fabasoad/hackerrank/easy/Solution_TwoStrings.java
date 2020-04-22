package io.github.fabasoad.hackerrank.easy;

import java.util.HashSet;
import java.util.Set;

public class Solution_TwoStrings {

    public static void main(String[] args) {
        assert "YES".equals(twoStrings("hello", "world"));
        assert "NO".equals(twoStrings("hi", "world"));
    }

    private static String twoStrings(String s1, String s2) {
        final Set<Character> s2Set = new HashSet<>();
        for (char c : s2.toCharArray()) {
            s2Set.add(c);
        }
        for (char c : s1.toCharArray()) {
            if (s2Set.contains(c)) {
                return "YES";
            }
        }
        return "NO";
    }
}
