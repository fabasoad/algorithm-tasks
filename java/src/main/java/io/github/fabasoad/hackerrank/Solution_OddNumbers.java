package io.github.fabasoad.hackerrank;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution_OddNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        int r = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = Result.oddNumbers(l, r);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
                + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static class Result {

        /*
         * Complete the 'oddNumbers' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts following parameters:
         *  1. INTEGER l
         *  2. INTEGER r
         */

        public static List<Integer> oddNumbers(int l, int r) {
            // Write your code here
            return IntStream.rangeClosed(l, r)
                .filter(n -> (n & 1) == 1)
                .boxed()
                .collect(toList());
        }
    }
}
