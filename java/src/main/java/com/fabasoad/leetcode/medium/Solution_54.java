package com.fabasoad.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

class Solution_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        final var result = new ArrayList<Integer>();
        int col_from = 0;
        int col_to = matrix[0].length - 1;
        int row_from = 0;
        int row_to = matrix.length - 1;
        while (row_from <= row_to && col_from <= col_to) {
            for (int k = col_from; k <= col_to; k++) {
                result.add(matrix[row_from][k]);
            }
            row_from++;
            if (row_from > row_to) {
                break;
            }
            for (int k = row_from; k <= row_to; k++) {
                result.add(matrix[k][col_to]);
            }
            col_to--;
            if (col_from > col_to) {
                break;
            }
            for (int k = col_to; k >= col_from; k--) {
                result.add(matrix[row_to][k]);
            }
            row_to--;
            if (row_to == 0) {
                break;
            }
            for (int k = row_to; k >= row_from; k--) {
                result.add(matrix[k][col_from]);
            }
            col_from++;
            if (col_from == matrix[0].length - 1) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        final var s = new Solution_54();
        List<Integer> result1 = s.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(result1);
        List<Integer> result2 = s.spiralOrder(new int[][]{{6, 9, 7}});
        System.out.println(result2);
        List<Integer> result3 = s.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
        System.out.println(result3);
        List<Integer> result4 = s.spiralOrder(new int[][]{{1,2},{3,4}});
        System.out.println(result4);
        List<Integer> result5 = s.spiralOrder(new int[][]{{2,5,8},{4,0,-1}});
        System.out.println(result5);
        // 23,18,20,26,25
        // 24,22,3, 4, 4
        // 15,22,2, 24,29
        // 18,15,23,28,28
        List<Integer> result6 = s.spiralOrder(new int[][]{{23,18,20,26,25},{24,22,3,4,4},{15,22,2,24,29},{18,15,23,28,28}});
        System.out.println(result6);
    }
}
