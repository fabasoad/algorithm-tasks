package com.fabasoad.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Solution_535 {

  public static class Codec {

    private static final String PREFIX = "https://tinyurl.com/";
    private static final int SHORT_URL_LENGTH = 12;

    private final Map<String, String> dbLong = new HashMap<>();
    private final Map<String, String> dbShort = new HashMap<>();

    private static String random() {
      final String uuid = UUID.randomUUID().toString();
      return uuid.substring(uuid.length() - SHORT_URL_LENGTH);
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
      if (dbLong.containsKey(longUrl)) {
        return dbLong.get(longUrl);
      }
      final String shortUrl = PREFIX + random();
      dbLong.put(longUrl, shortUrl);
      dbShort.put(shortUrl, longUrl);
      return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
      return dbShort.get(shortUrl);
    }
  }

  public static void main(String[] args) {
    final var url1 = "https://leetcode.com/problems/design-tinyurl-1";
    final var url2 = "https://leetcode.com/problems/design-tinyurl-2";
    final var codec = new Codec();
    assert url1.equals(codec.decode(codec.encode(url1)));
    assert url2.equals(codec.decode(codec.encode(url2)));
  }
}
