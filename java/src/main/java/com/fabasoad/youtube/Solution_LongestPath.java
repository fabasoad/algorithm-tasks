package com.fabasoad.youtube;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * https://youtu.be/IWvbPIYQPFM
 */
public class Solution_LongestPath {

    public static void main(String[] args) {
        // 1, 1, 2, 2
        // 4, 1, 4, 3
        // 4, 4, 4, 3
        final var input = new int[][] {
            new int[] { 1, 1, 2, 2 },
            new int[] { 4, 1, 4, 3 },
            new int[] { 4, 4, 4, 3 },
        };
        final var result = find(input);
        System.out.println(result.size());
    }

    public static Collection<int[]> find(int[][] m) {
        final var res = new ArrayList<LinkedList<int[]>>();
        boolean[][] v = new boolean[m.length][];
        for (int i = 0; i < v.length; i++) {
            v[i] = new boolean[m[i].length];
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (!v[i][j]) {
                    final var data = new LinkedList<int[]>();
                    v[i][j] = true;
                    find(m, i, j, v, data);
                    if (!data.isEmpty()) {
                        res.add(data);
                    }
                }
            }
        }
        return res.stream().max(Comparator.comparing(Collection::size)).orElseGet(LinkedList::new);
    }

    private static void find(int[][] m, int i, int j, boolean[][] v, LinkedList<int[]> data) {
        if (i > 0 && !v[i - 1][j] && m[i -1][j] == m[i][j]) {
            v[i - 1][j] = true;
            find(m, i - 1, j, v, data);
        }
        if (i < m.length - 1 && !v[i + 1][j] && m[i +1][j] == m[i][j]) {
            v[i + 1][j] = true;
            find(m, i + 1, j, v, data);
        }
        if (j > 0 && !v[i][j - 1] && m[i][j - 1] == m[i][j]) {
            v[1][j - 1] = true;
            find(m, i, j - 1, v, data);
        }
        if (j < m.length - 1 && !v[i][j + 1] && m[i][j + 1] == m[i][j]) {
            v[i][j + 1] = true;
            find(m, i, j + 1, v, data);
        }
        data.add(new int[] { i, j });
    }
}
