package io.github.fabasoad.hackerrank;

import java.util.Objects;

/**
 * https://www.hackerrank.com/challenges/time-conversion/problem
 */
public class Solution_TimeConversion {

    public static void main(String[] args) {
        System.out.println(timeConversion("12:00:00AM"));
    }

    private static String timeConversion(String s) {
        final String suffix = s.substring(s.length() - 2);
        final String[] time = s.substring(0, s.length() - 2).split(":");
        final int hour = Integer.parseInt(time[0].startsWith("0") ? time[0].substring(1) : time[0]);
        return String.format("%02d:%s:%s", Objects.equals(suffix, "PM")
                ? (hour == 12 ? hour : hour + 12)
                : (hour == 12 ? hour - 12 : hour),
            time[1], time[2]);
    }
}
