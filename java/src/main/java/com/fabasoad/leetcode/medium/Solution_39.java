package com.fabasoad.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_39 {

  private void combinationSum(int[] candidates, int target, List<Integer> bag, Set<List<Integer>> result) {
    for (int c : candidates) {
      if (target - c == 0) {
        final ArrayList<Integer> newBag = new ArrayList<>(bag);
        newBag.add(c);
        newBag.sort(Integer::compareTo);
        result.add(newBag);
      } else if (target - c > 0) {
        final ArrayList<Integer> newBag = new ArrayList<>(bag);
        newBag.add(c);
        combinationSum(candidates, target - c, newBag, result);
      }
    }
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    final Set<List<Integer>> result = new HashSet<>();
    combinationSum(candidates, target, new ArrayList<>(), result);
    return new ArrayList<>(result);
  }

  public static void main(String[] args) {
    final Solution_39 s = new Solution_39();
    List<List<Integer>> result = s.combinationSum(new int[]{2, 3, 6, 7}, 7);
    System.out.println(result);
    result = s.combinationSum(new int[]{2,7,6,3,5,1}, 9);
    System.out.println(result);
  }
}
