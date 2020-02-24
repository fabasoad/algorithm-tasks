package hackerrank;

import java.util.stream.LongStream;

public class Solution_VeryBigSum {

    public static void main(String[] args) {
        System.out.println(aVeryBigSum(new long[] {
            1001458909,
            1004570889,
            1007019111,
            1003302837,
            1002514638,
            1006431461,
            1002575010,
            1007514041,
            1007548981,
            1004402249
        }));
    }

    static long aVeryBigSum(long[] ar) {
        return LongStream.of(ar).mapToObj(String::valueOf).reduce(Solution_VeryBigSum::sum).map(Long::parseLong).orElse(0L);
    }

    static String sum(String a, String b) {
        final String res = sum(a, b, "", a.length() - 1, a.length(), b.length() - 1, b.length(), 0);
        return res;
    }

    static String sum(String a, String b, String res, int aStart, int aEnd, int bStart, int bEnd, int c_int) {
        int a_int = Integer.parseInt(a.substring(aStart, aEnd));
        int b_int = Integer.parseInt(b.substring(bStart, bEnd));
        String result = String.valueOf(a_int + b_int + c_int);
        if (aStart > 0 && bStart > 0) {
            String finalResult = "";
            int new_c_int = 0;
            if (result.length() > 1) {
                finalResult = result.substring(result.length() - 1) + res;
                new_c_int = Integer.parseInt(result.substring(0, result.length() - 1));
            } else {
                finalResult = result + res;
            }
            return sum(a, b, finalResult, aStart - 1, aEnd - 1, bStart - 1, bEnd - 1, new_c_int);
        } else {
            return result + res;
        }
    }
}
