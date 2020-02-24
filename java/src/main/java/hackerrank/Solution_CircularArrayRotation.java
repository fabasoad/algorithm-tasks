package hackerrank;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution_CircularArrayRotation {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(circularArrayRotation(new int[]{2, 3, 1}, 2, new int[]{0, 2})));
    }

    private static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int counter = k;
        ArrayDeque<Integer> queue = new ArrayDeque<>(a.length);
        Arrays.stream(a).forEach(queue::add);
        while (counter > 0 && !queue.isEmpty()) {
            queue.addFirst(queue.pollLast());
            counter--;
        }
        Integer[] v = queue.toArray(new Integer[0]);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = v[queries[i]];
        }
        return result;
    }
}
