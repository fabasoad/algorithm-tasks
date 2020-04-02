package io.github.fabasoad.hackerrank;

public class Solution_TutorialIntro {

    public static void main(String[] args) {
        assert 1 == introTutorial(2, new int[] { 1, 2, 4, 5, 67, 333, 334 });
        assert 3 == introTutorial(5, new int[] { 1, 2, 4, 5, 67, 333, 334 });
        assert 0 == introTutorial(1, new int[] { 1, 2, 4, 67, 333, 334 });
        assert 3 == introTutorial(67, new int[] { 1, 2, 4, 67, 333, 334 });
        assert -1 == introTutorial(167, new int[] { 1, 2, 4, 67, 333, 334 });
    }

    static int introTutorial(int V, int[] arr) {
        return search(arr, V, 0, arr.length);
    }

    static int search(int[] arr, int V, int s, int e) {
        int mid = (e + s) / 2;
        if (arr[mid] == V) {
            return mid;
        } else if (e - s <= 1) {
            return -1;
        } else if (arr[mid] > V) {
            return search(arr, V, s, mid);
        } else {
            return search(arr, V, mid, e);
        }
    }
}
