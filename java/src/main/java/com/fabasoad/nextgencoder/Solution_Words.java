package com.fabasoad.nextgencoder;

import java.util.Stack;

/**
 * https://www.instagram.com/p/B_SiifdAUMA/
 */
public class Solution_Words {

    public static void main(String[] args) {
        System.out.println(areEqual("AS##NGD#CD#", "G#NGC"));
    }

    private static void processString(String w, Stack<Character> stack) {
        for (char ch : w.toCharArray()) {
            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
    }

    private static boolean areEqual(String w1, String w2) {
        var stack1 = new Stack<Character>();
        var stack2 = new Stack<Character>();
        processString(w1, stack1);
        processString(w2, stack2);
        var iter1 = stack1.iterator();
        var iter2 = stack2.iterator();
        while (iter1.hasNext() && iter2.hasNext()) {
            if (iter1.next() != iter2.next()) {
                break;
            }
        }
        return !iter1.hasNext() && !iter2.hasNext();
    }
}
