package com.fabasoad.custom;

import java.util.Arrays;

class LongestCommonSubList {

  private static String[] findLongestCommonSubList(
      String[] user1, int from1, int to1,
      String[] user2, int from2, int to2) {
    if (to1 - from1 < 0 || to2 - from2 < 0) {
      return new String[0];
    }
    if (to1 - from1 == to2 - from2) {
      int i = from1;
      int j = from2;
      while (i <= to1 && j <= to2) {
        if (!user1[i].equals(user2[j])) {
          break;
        }
        i++;
        j++;
      }
      if (i > to1 && j > to2) {
        return Arrays.copyOfRange(user1, from1, to1 + 1);
      }
    }
    final String[] a = findLongestCommonSubList(user1, from1, to1, user2, from2, to2 - 1);
    final String[] b = findLongestCommonSubList(user1, from1, to1, user2, from2 + 1, to2);
    final String[] c = findLongestCommonSubList(user1, from1 + 1, to1, user2, from2, to2);
    final String[] d = findLongestCommonSubList(user1, from1, to1 - 1, user2, from2, to2);
    final String[] e = a.length > b.length ? a : b;
    final String[] f = c.length > d.length ? c : d;
    return e.length > f.length ? e : f;
  }

  private static String[] findLongestCommonSubList(String[] user1, String[] user2) {
    return findLongestCommonSubList(
      user1, 0, user1.length - 1, user2, 0, user2.length - 1);
  }

  public static void main(String[] args) {
    final String[] user0 = new String[] {"/beer", "/orange", "/apple", "/pineapple", "/strawberry"};
    final String[] user1 = new String[] {"/beer", "/potato", "/orange", "/apple", "/pineapple"};
    final String[] user2 = new String[] {"/beer", "/potato", "/orange", "/apple", "/pineapple"};
    final String[] user3 = new String[] {"/apple"};
    final String[] user4 = new String[] {"/cranberry"};
    final String[] user5 = new String[] {"/beer", "/cranberry", "/apple", "/strawberry"};
    final String[] user6 = new String[] {"/beer", "/potato", "/orange", "/apple", "/pineapple"};
    System.out.println(Arrays.toString(findLongestCommonSubList(user0, user1)));
    System.out.println(Arrays.toString(findLongestCommonSubList(user1, user2)));
    System.out.println(Arrays.toString(findLongestCommonSubList(user1, user3)));
    System.out.println(Arrays.toString(findLongestCommonSubList(user1, user4)));
    System.out.println(Arrays.toString(findLongestCommonSubList(user5, user6)));
  }
}
