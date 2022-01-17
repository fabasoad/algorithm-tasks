package com.fabasoad.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution_811 {

  public static void main(String[] args) {
    System.out.println(subdomainVisits(new String[] {
        "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" }));
  }

  private static void parse(String domain, Map<String, Integer> res) {
    final int space_ind = domain.indexOf(" ");
    final int rep = Integer.parseInt(domain.substring(0, space_ind));
    int from = space_ind;
    while (from >= 0) {
      res.merge(domain.substring(from + 1), rep, Integer::sum);
      from = domain.indexOf(".", from + 1);
    }
  }

  public static List<String> subdomainVisits(String[] cpdomains) {
    final Map<String, Integer> res = new HashMap<>();
    for (final String d : cpdomains) {
      parse(d, res);
    }
    return res.entrySet()
        .stream()
        .map(e -> String.format("%s %s", e.getValue(), e.getKey()))
        .collect(Collectors.toList());
  }
}
