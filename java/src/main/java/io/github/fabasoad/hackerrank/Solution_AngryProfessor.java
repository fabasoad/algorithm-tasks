package io.github.fabasoad.hackerrank;

public class Solution_AngryProfessor {

    public static void main(String[] args) {
        assert "YES".equals(angryProfessor(3, new int[] { -1, -3, 4, 2 }));
        assert "NO".equals(angryProfessor(2, new int[] { 0, -1, 2, 1 }));
    }

    private static String angryProfessor(int k, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= 0) {
                k--;
            }
        }
        return k > 0 ? "YES" : "NO";
    }
}
