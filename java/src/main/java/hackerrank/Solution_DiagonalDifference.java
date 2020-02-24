package hackerrank;

import java.util.List;

import static java.util.Arrays.asList;

public class Solution_DiagonalDifference {

    public static void main(String[] args) {
        System.out.println(diagonalDifference(asList(
            asList(11, 2, 4),
            asList(4, 5, 6),
            asList(10, 8, -12)
        )));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int sum1 = 0;
        int sum2 = 0;
        int i = 0;
        while (i < arr.size()) {
            sum1 += arr.get(i).get(i);
            i++;
        }
        int row = 0;
        int col = arr.size() - 1;
        while (row < arr.size()) {
            sum2 += arr.get(row).get(col);
            row++;
            col--;
        }
        return Math.abs(sum1 - sum2);
    }
}
