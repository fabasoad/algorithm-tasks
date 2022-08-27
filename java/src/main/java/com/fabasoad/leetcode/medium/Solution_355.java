package com.fabasoad.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution_355 {

  private final Map<Integer, Integer> tweets;
  private final Map<Integer, Set<Integer>> followers;

  public Solution_355() {
    this.tweets = new LinkedHashMap<>();
    this.followers = new HashMap<>();
  }

  public void postTweet(int userId, int tweetId) {
    this.tweets.put(tweetId, userId);
  }

  public List<Integer> getNewsFeed(int userId) {
    final List<Integer> res = new ArrayList<>();
    final List<Integer> keys = new ArrayList<>(tweets.keySet());
    Collections.reverse(keys);
    for (int tweetId : keys) {
      if (tweets.get(tweetId) == userId || (followers.containsKey(userId) && followers.get(userId).contains(tweets.get(tweetId)))) {
        res.add(tweetId);
        if (res.size() == 10) {
          break;
        }
      }
    }
    return res;
  }

  public void follow(int followerId, int followeeId) {
    this.followers.putIfAbsent(followerId, new HashSet<>());
    this.followers.get(followerId).add(followeeId);
  }

  public void unfollow(int followerId, int followeeId) {
    if (this.followers.containsKey(followerId)) {
      this.followers.get(followerId).remove(followeeId);
    }
  }

  public static void main(String[] args) {
    final Solution_355 s = new Solution_355();
    s.postTweet(1, 5);
    s.postTweet(1, 3);
    s.postTweet(1, 101);
    s.postTweet(1, 13);
    s.postTweet(1, 10);
    s.postTweet(1, 2);
    s.postTweet(1, 94);
    s.postTweet(1, 505);
    s.postTweet(1, 333);
    s.postTweet(1, 22);
    s.postTweet(1, 11);
    System.out.println(s.getNewsFeed(1));
  }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */