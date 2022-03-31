package com.fabasoad.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_18 {

  private boolean search(int[] nums, int from, int to, int target) {
    while (from <= to) {
      int mid = (to - from) / 2 + from;
      if (nums[mid] < target) {
        from = mid + 1;
      } else if (nums[mid] > target) {
        to = mid - 1;
      } else {
        return true;
      }
    }
    return false;
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    final Set<List<Integer>> result = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          int sum = nums[i] + nums[j] + nums[k];
          final int toSearch = target - sum;
          if (search(nums, k + 1, nums.length - 1, toSearch)) {
            final List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            list.add(nums[j]);
            list.add(nums[k]);
            list.add(toSearch);
            result.add(list);
          }
        }
      }
    }
    return new ArrayList<>(result);
  }

  // Time limit exceeded
  /* private Set<List<Integer>> twoSum(int[] nums, int from, int to, int target) {
    final Set<List<Integer>> result = new HashSet<>();
    final Map<Integer, Integer> map = new HashMap<>();
    for (int i = from; i <= to; i++) {
      map.putIfAbsent(target - nums[i], i);
    }
    for (int i = to; i >= from; i--) {
      if (map.containsKey(nums[i]) && map.get(nums[i]) < i) {
        final List<Integer> list = new ArrayList<>();
        list.add(nums[from - 1]);
        list.add(nums[i]);
        list.add(target - nums[i]);
        list.add(nums[to + 1]);
        list.sort(Integer::compareTo);
        result.add(list);
      }
    }
    if (to - from > 1) {
      result.addAll(twoSum(nums, from + 1, to, target + nums[from - 1] - nums[from]));
      result.addAll(twoSum(nums, from, to - 1, target + nums[to + 1] - nums[to]));
    }
    return result;
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    return twoSum(nums, 1, nums.length - 2, target - nums[0] - nums[nums.length - 1]).stream().toList();
  }*/

  public static void main(String[] args) {
    final Solution_18 s = new Solution_18();
    // [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    System.out.println(s.fourSum(new int[] {1,0,-1,0,-2,2}, 0));
    System.out.println(s.fourSum(new int[] {2,2,2,2,2}, 8));
  }

}
