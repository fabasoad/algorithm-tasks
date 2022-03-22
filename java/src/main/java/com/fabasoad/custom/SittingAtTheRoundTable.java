package com.fabasoad.custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SittingAtTheRoundTable {

  private List<List<Integer>> permute(int[] nums) {
    return permutation(new ArrayList<>(), nums);
  }

  private List<List<Integer>> permutation(List<Integer> p, int[] up) {
    if (up.length == 0) {
      List<List<Integer>> sublist = new ArrayList<>();
      sublist.add(p);
      return sublist;
    }
    int num = up[0];
    List<List<Integer>> ans=new ArrayList<>();
    for (int i = 0; i <= p.size(); i++) {
      List<Integer> new1 = new ArrayList<>(p.subList(0, i));
      new1.add(num);
      new1.addAll(p.subList(i, p.size()));
      ans.addAll(permutation(new1, Arrays.copyOfRange(up, 1, up.length)));
    }
    return ans;
  }

  private boolean isValid(int a, int b, int x, int z) {
    if ((a == x && b == z) || (a == z && b == x)) {
      return false;
    }
    return true;
  }

  private boolean isValid(List<Integer> nums, int[][] friendships) {
    for (int[] fr : friendships) {
      for (int i = 0; i < nums.size() - 1; i++) {
        if (!isValid(nums.get(i), nums.get(i + 1), fr[0], fr[1])) {
          return false;
        }
      }
      if (!isValid(nums.get(0), nums.get(nums.size() - 1), fr[0], fr[1])) {
        return false;
      }
    }
    return true;
  }

  public int calculateValidOptions(int n, int[][] friendships) {
    final int[] num = new int[n];
    for (int i = 0; i < n; i++) {
      num[i] = i + 1;
    }
    final Set<List<Integer>> validTables = new HashSet<>();
    final List<List<Integer>> allTables = permute(num);
    for (List<Integer> table : allTables) {
      if (isValid(table, friendships)) {
        int pos1 = table.indexOf(1);
        final List<Integer> copy = new ArrayList<>();
        copy.addAll(table.subList(pos1, table.size()));
        copy.addAll(table.subList(0, pos1));
        validTables.add(copy);
      }
    }
    return validTables.size();
  }

  public static void main(String[] args) {
    final SittingAtTheRoundTable s = new SittingAtTheRoundTable();
    assert 2 == s.calculateValidOptions(4, new int[][] {{1,2}});
    assert 24 == s.calculateValidOptions(5, new int[0][]);
    assert 112512 == s.calculateValidOptions(10, new int[][] {{1,2},{3,4},{5,6},{7,8},{9,10}});
  }
}
