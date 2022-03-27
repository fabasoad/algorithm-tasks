package com.fabasoad.leetcode.easy;

import java.util.Arrays;

class Solution_2114 {
    public int mostWordsFound(String[] sentences) {
        return (int) Arrays.stream(sentences)
            .mapToLong(s -> Arrays.stream(s.split(" ")).count())
            .max()
            .orElse(0L);
    }
}