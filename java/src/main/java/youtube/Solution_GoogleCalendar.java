package youtube;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * https://youtu.be/3Q_oYDQ2whs
 */
public class Solution_GoogleCalendar {
    public static void main(String[] args) {
        final var cal1 = new String[][]{
            new String[]{"9:00", "10:30"},
            new String[]{"12:00", "13:00"},
            new String[]{"16:00", "18:00"}
        };
        final var bound1 = new String[]{"9:00", "20:00"};
        final var cal2 = new String[][]{
            new String[]{"10:00", "11:30"},
            new String[]{"12:30", "14:30"},
            new String[]{"14:30", "15:00"},
            new String[]{"16:00", "17:00"}
        };
        final var bound2 = new String[]{"10:00", "18:30"};
        final var step = 30;

        final var runner = new Solution_GoogleCalendar();
        final var result = runner.run(cal1, bound1, cal2, bound2, step);
        System.out.println(result.stream().map(p -> p[0] + ":" + p[1]).collect(Collectors.joining(",")));
    }

    // O(n)
    private static void traverse(final String[][] cal, final boolean[] booked, final int l, final int r) {
        for (final var pair : cal) {
            final var a = Math.max(tom(pair[0]), l);
            final var b = Math.min(tom(pair[1]), r);
            for (var i = a; i < b; i++) {
                booked[i - l] = true;
            }
        }
    }

    public Collection<String[]> run(
        final String[][] cal1, final String[] bound1, final String[][] cal2, final String[] bound2, final int step) {
        final var leftBorder = Math.max(tom(bound1[0]), tom(bound2[0]));
        final var rightBorder = Math.min(tom(bound1[1]), tom(bound2[1]));

        final var booked = new boolean[rightBorder - leftBorder];
        traverse(cal1, booked, leftBorder, rightBorder); // O(n)
        traverse(cal2, booked, leftBorder, rightBorder); // O(n)

        var result = new ArrayList<String[]>();
        var counter = new int[]{ leftBorder, leftBorder };
        // O(n)
        for (int i = 0; i < booked.length; i++) {
            if (!booked[i]) {
                counter[1]++;
            } else {
                check(counter, step, result);
                counter[0] = i + leftBorder;
                counter[1] = i + leftBorder;
            }
        }
        check(counter, step, result);
        return result;
    }

    private static void check(final int[] counter, final int step, final Collection<String[]> result) {
        if (counter[1] - counter[0] >= step) {
            result.add(new String[]{ fromm(counter[0] + 1), fromm(counter[1] + 1) });
        }
    }

    private static int tom(final String timeAsString) {
        return LocalTime.parse(timeAsString, DateTimeFormatter.ofPattern("H:mm")).get(ChronoField.MINUTE_OF_DAY);
    }

    private static String fromm(final int timeAsInt) {
        return LocalTime.ofSecondOfDay(timeAsInt * 60).format(DateTimeFormatter.ofPattern("H:mm"));
    }
}
