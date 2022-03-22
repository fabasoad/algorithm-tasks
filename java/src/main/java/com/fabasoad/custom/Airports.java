package com.fabasoad.custom;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Airports {

  public static int findMinimum(
      List<String> airports, String[][] routes, String startingPoint) {
    final Set<String> toSet = new HashSet<>();
    final Set<String> fromSet = new HashSet<>();
    for (String[] route : routes) {
      fromSet.add(route[0]);
      toSet.add(route[1]);
    }
    final Set<String> all = new HashSet<>(airports);
    int count = 0;
    for (String from : fromSet) {
      if (!toSet.contains(from)) {
        count++;
      }
      all.remove(from);
    }
    return count;
  }

  public static void main(String[] args) {
    assert 3 == findMinimum(
      List.of(
        "BGI","CDG","DEL","DOH","DSM","EWR","EYW","HND","ICN",
        "JFK","LGA","LHR","ORD","SAN","SFO","SIN","TLV","BUD"),
      new String[][] {
        {"DSM","ORD"},
        {"ORD","BGI"},
        {"BGI","LGA"},
        {"SIN","CDG"},
        {"CDG","SIN"},
        {"CDG","BUD"},
        {"DEL","DOH"},
        {"DEL","CDG"},
        {"TLV","DEL"},
        {"EWR","HND"},
        {"HND","ICN"},
        {"HND","JFK"},
        {"ICN","JFK"},
        {"JFK","LGA"},
        {"EYW","LHR"},
        {"LHR","SFO"},
        {"SFO","SAN"},
        {"SFO","DSM"},
        {"SAN","EYW"}
      }, "LGA");
  }
}
