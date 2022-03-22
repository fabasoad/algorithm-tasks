package com.fabasoad.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreePrinter {

  private static class Relation {
    String from;
    String to;
    Relation(String from, String to) {
      this.from = from;
      this.to = to;
    }
  }

  private static class TreeNode {
    String val;
    List<TreeNode> nodes = new ArrayList<>();
    TreeNode(String val) {
      this.val = val;
    }
  }

  private static void printTree(List<Relation> input) {
    final Map<String, TreeNode> map = new HashMap<>();
    final Map<String, Integer> possibleRoots = new HashMap<>();
    for (Relation rel : input) {
      if (!map.containsKey(rel.from)) {
        final var node = new TreeNode(rel.from);
        map.put(rel.from, node);
      }
      if (!map.containsKey(rel.to)) {
        final var node = new TreeNode(rel.to);
        map.put(rel.to, node);
      }
      map.get(rel.from).nodes.add(map.get(rel.to));
      if (!possibleRoots.containsKey(rel.from)) {
        possibleRoots.put(rel.from, 0);
      }
      possibleRoots.merge(rel.to, 1, Integer::sum);
    }
    for (Map.Entry<String, Integer> e : possibleRoots.entrySet()) {
      if (e.getValue() == 0) {
        final TreeNode root = map.get(e.getKey());
        printTree(root, 0);
      }
    }
  }

  private static void printTree(TreeNode node, int spaces) {
    if (node != null) {
      System.out.print(" ".repeat(spaces));
      System.out.println(node.val);
      for (TreeNode child : node.nodes) {
        printTree(child, spaces + 2);
      }
    }
  }

  public static void main(String[] args) {
    final var input = new ArrayList<Relation>();
    input.add(new Relation("animal", "mammal"));
    input.add(new Relation("animal", "bird"));
    input.add(new Relation("lifeform", "animal"));
    input.add(new Relation("cat", "lion"));
    input.add(new Relation("mammal", "cat"));
    input.add(new Relation("animal", "fish"));
    input.add(new Relation("planet", "sea"));
    // lifeform
    //   animal
    //     mammal
    //       cat
    //         lion
    //     bird
    //     fish
    TreePrinter.printTree(input);
  }
}



