package io.github.fabasoad.leetcode.medium;

import java.util.Arrays;

public class Solution_MinimumNumberOfOperationsToMoveAllBallsToEachBox {

  private static int[] strToArray(final String boxes) {
    final int[] result = new int[boxes.length()];
    for (int i = 0; i < boxes.length(); i++) {
      result[i] = boxes.charAt(i) == '1' ? 1 : 0;
    }
    return result;
  }

  public static int[] minOperations(final String boxes) {
    final int[] boxesOrig = strToArray(boxes);
    int[] boxesInt = Arrays.copyOf(boxesOrig, boxesOrig.length);

    final int[] leftToRight = new int[boxesInt.length];
    for (int i = 0; i < boxesInt.length - 1; i++) {
      if (boxesInt[i] > 0) {
        leftToRight[i + 1] = leftToRight[i] + boxesInt[i];
        boxesInt[i + 1] = boxesInt[i + 1] + boxesInt[i];
        boxesInt[i] = 0;
      }
    }

    boxesInt = Arrays.copyOf(boxesOrig, boxesOrig.length);
    final int[] rightToLeft = new int[boxesInt.length];
    for (int i = boxesInt.length - 1; i > 0; i--) {
      if (boxesInt[i] > 0) {
        rightToLeft[i - 1] = rightToLeft[i] + boxesInt[i];
        boxesInt[i - 1] = boxesInt[i - 1] + boxesInt[i];
        boxesInt[i] = 0;
      }
    }
    int[] total = new int[boxesOrig.length];
    for (int i = 0; i < total.length; i++) {
      total[i] = leftToRight[i] + rightToLeft[i];
    }
    return total;
  }

  public static void main(String[] args) {
    assert Arrays.equals(minOperations("110"), new int[]{1, 1, 3});
    assert Arrays.equals(minOperations("001011"), new int[]{11,8,5,4,3,4});
  }

}
