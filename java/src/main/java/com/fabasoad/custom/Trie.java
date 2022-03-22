package com.fabasoad.custom;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

class Trie {

  private static final char EMPTY = 'A' - 1;
  private final TrieNode head = new TrieNode();

  public void insert(String word) {
    TrieNode node = head;
    for (int i = 0; i < word.length(); i++) {
      char pref = word.charAt(i);
      if (node.children.containsKey(pref)) {
        node = node.children.get(pref);
      } else {
        final TrieNode n = new TrieNode(pref, false);
        node.children.put(pref, n);
        node = n;
      }
    }
    node.isWord = true;
  }

  private boolean search(String word, Function<TrieNode, Boolean> processor) {
    TrieNode node = head;
    for (int i = 0; i < word.length(); i++) {
      char pref = word.charAt(i);
      if (node.children.containsKey(pref)) {
        node = node.children.get(pref);
        continue;
      }
      return false;
    }
    return processor.apply(node);
  }

  public boolean search(String word) {
    return search(word, n -> n.isWord);
  }

  public boolean startsWith(String prefix) {
    return search(prefix, ignored -> true);
  }

  public static void main(String[] args) {
    final Trie trie = new Trie();
    trie.insert("apple");
    assert trie.search("apple");
    assert !trie.search("app");
    assert trie.startsWith("app");
    trie.insert("app");
    assert trie.search("app");
    assert !trie.search("ape");
    assert !trie.startsWith("ape");
  }

  private static class TrieNode {
    char c;
    boolean isWord;
    Map<Character, TrieNode> children;
    TrieNode() {
      this(false);
    }
    TrieNode(boolean isWord) {
      this(EMPTY, isWord);
    }
    TrieNode(char c, boolean isWord) {
      this.c = c;
      this.isWord = isWord;
      this.children = new HashMap<>();
    }
  }
}

