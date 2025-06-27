import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Tweets {

  static class Tweet {
    double score;
    String author;

    Tweet(double score, String author) {
      this.score = score;
      this.author = author;
    }
  }

  public List<Tweet> getFeed(List<Tweet> tweets) {
    final var map = new HashMap<String, PriorityQueue<Tweet>>();
    for (final Tweet tweet : tweets) {
      if (!map.containsKey(tweet.author)) {
        map.put(tweet.author, new PriorityQueue<>((t1, t2) -> Double.compare(t2.score, t1.score)));
      }
      map.get(tweet.author).add(tweet);
    }
    final var queue = new PriorityQueue<Map.Entry<String, PriorityQueue<Tweet>>>(
        (a, b) -> Double.compare(b.getValue().peek().score, a.getValue().peek().score)
    );

    for (final Map.Entry<String, PriorityQueue<Tweet>> entry : map.entrySet()) {
      queue.add(entry);
    }

    final var res = new LinkedList<Tweet>();
    Map.Entry<String, PriorityQueue<Tweet>> node = queue.poll();
    while (node != null) {
      final var tweet = node.getValue().poll();
      res.add(tweet);
      if (queue.isEmpty()) {
        if (!node.getValue().isEmpty()) {
          queue.add(node);
        }
        node = queue.poll();
      } else {
        var nextNode = queue.poll();
        if (!node.getValue().isEmpty()) {
          queue.add(node);
        }
        node = nextNode;
      }
    }
    return res;
  }
  

  public static void main(String[] args) {
    final var tweets = new LinkedList<Tweet>();
    // [(.6, "A"), (.5, "A"), (.4, "B"), (.3, "B"), (.2, "C"), (.1, "C")]
    // tweets.add(new Tweet(0.6, "A"));
    // tweets.add(new Tweet(0.5, "A"));
    // tweets.add(new Tweet(0.4, "B"));
    // tweets.add(new Tweet(0.3, "B"));
    // tweets.add(new Tweet(0.2, "C"));
    // tweets.add(new Tweet(0.1, "C"));
    // [(.5, "A"), (.4, "A"), (.3, "A"), (.2, "B"), (.1, "A")]
//    tweets.add(new Tweet(0.5, "A"));
//    tweets.add(new Tweet(0.4, "A"));
//    tweets.add(new Tweet(0.3, "A"));
//    tweets.add(new Tweet(0.2, "B"));
//    tweets.add(new Tweet(0.1, "A"));
    // [(.7, "A"), (.6, "C"), (.5, "B"), (.4, "B"), (.3, "C"), (.2, "C"), (.1, "A")]
    tweets.add(new Tweet(0.7, "A"));
    tweets.add(new Tweet(0.6, "C"));
    tweets.add(new Tweet(0.5, "B"));
    tweets.add(new Tweet(0.4, "B"));
    tweets.add(new Tweet(0.3, "C"));
    tweets.add(new Tweet(0.2, "C"));
    tweets.add(new Tweet(0.1, "A"));
    final var solution = new Tweets();
    final List<Tweet> feed = solution.getFeed(tweets);
    for (final Tweet tweet : feed) {
      System.out.println(String.format("%s: %s", tweet.score, tweet.author));
    }
  }
}
