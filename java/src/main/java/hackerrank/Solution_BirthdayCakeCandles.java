package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class Solution_BirthdayCakeCandles {

    public static void main(String[] args) {
        System.out.println(birthdayCakeCandles(new int[] { 4, 4, 3, 2 }));
    }

    static int birthdayCakeCandles(int[] ar) {
        final Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > max) {
                max = ar[i];
            }
            map.compute(ar[i], (k, v) -> v == null ? 1 : v + 1);
        }
        return map.get(max);
    }
}
