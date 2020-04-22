package io.github.fabasoad.hackerrank.medium;

/**
 * https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem
 */
public class Solution_SortingComparator {

    public int compare(Player a, Player b) {
        if (a.score > b.score) {
            return -1;
        } else if (a.score < b.score) {
            return 1;
        } else {
            return a.name.compareTo(b.name);
        }
    }

    private static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
