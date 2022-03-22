package com.fabasoad.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_46 {

  public List<List<Integer>> permute(int[] nums) {
    return permutation(new ArrayList<>(), nums);
  }

  public List<List<Integer>> permutation(List<Integer> p, int[] up) {
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

  public static void main(String[] args) {
    final Solution_46 s = new Solution_46();
    System.out.println(s.permute(new int[] { 1,2,3 }));
    System.out.println(s.permute(new int[] { 0,1 }));
    System.out.println(s.permute(new int[] { 1 }));
    System.out.println(s.permute(new int[] { 5,4,6,2 }));
  }
}
