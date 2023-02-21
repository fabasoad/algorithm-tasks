package com.fabasoad.leetcode.easy;

import java.util.Stack;

public class Solution_1047 {

  public String removeDuplicates(String s) {
    final var st = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
      if (st.empty()) {
        st.add(s.charAt(i));
      } else {
        final char c = st.peek();
        if (c == s.charAt(i)) {
          st.pop();
        } else {
          st.add(s.charAt(i));
        }
      }
    }
    final var res = new StringBuilder();
    while (!st.empty()) {
      res.insert(0, st.pop());
    }
    return res.toString();
  }

  public static void main(String[] args) {
    final var s = new Solution_1047();
    assert "ca".equals(s.removeDuplicates("abbaca"));
    assert "ay".equals(s.removeDuplicates("azxxzy"));
    assert "ehflcjmgljhbjecdikajfdmadcfdiahkaglkeifdcljcgmfgflijgihiejmfgekaljkmfkdfikjgkb".equals(
        s.removeDuplicates("ehflcjmgljhbjecdbbikajfdmabbdcfdiahkaglkeibbfdcljcghhmfgfmfjjfaamlijgihiejmccfiigekaljkmfklldfikjgkb")
    );
  }
}
