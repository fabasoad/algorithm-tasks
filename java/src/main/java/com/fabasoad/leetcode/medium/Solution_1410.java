package com.fabasoad.leetcode.medium;

public class Solution_1410 {

  private static final char _AMP = '&';
  private static final String QUOT = "&quot;";
  private static final String APOS = "&apos;";
  private static final String AMP = "&amp;";
  private static final String GT = "&gt;";
  private static final String LT = "&lt;";
  private static final String FRASL = "&frasl;";

  public String entityParser(String text) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == _AMP) {
        if (text.length() >= i + QUOT.length() && text.startsWith(QUOT, i)) {
          sb.append("\"");
          i += QUOT.length() - 1;
        } else if (text.length() >= i + APOS.length() && text.startsWith(APOS, i)) {
          sb.append("'");
          i += APOS.length() - 1;
        } else if (text.length() >= i + AMP.length() && text.startsWith(AMP, i)) {
          sb.append("&");
          i += AMP.length() - 1;
        } else if (text.length() >= i + LT.length() && text.startsWith(LT, i)) {
          sb.append("<");
          i += LT.length() - 1;
        } else if (text.length() >= i + GT.length() && text.startsWith(GT, i)) {
          sb.append(">");
          i += GT.length() - 1;
        } else if (text.length() >= i + FRASL.length() && text.startsWith(FRASL, i)) {
          sb.append("/");
          i += FRASL.length() - 1;
        } else {
          sb.append(text.charAt(i));
        }
      } else {
        sb.append(text.charAt(i));
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    final Solution_1410 s = new Solution_1410();
    assert "& is an HTML entity but &ambassador; is not.".equals(s.entityParser("&amp; is an HTML entity but &ambassador; is not."));
    assert "and I quote: \"...\"".equals(s.entityParser("and I quote: &quot;...&quot;"));
  }
}
