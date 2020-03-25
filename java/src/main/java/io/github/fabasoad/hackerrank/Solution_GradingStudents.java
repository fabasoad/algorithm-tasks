package io.github.fabasoad.hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/grading/problem
 */
public class Solution_GradingStudents {

    public static void main(String[] args) {
        System.out.println(gradingStudents(new ArrayList<Integer>() {
            { add(100); }
            { add(97); }
            { add(98); }
            { add(99); }
        }));
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        final List<Integer> result = new ArrayList<>();
        for (int grade : grades) {
            int i = grade;
            if (grade >= 38) {
                while (i % 5 != 0) {
                    i++;
                }
            }
            result.add(i - grade < 3 ? i : grade);
        }
        return result;
    }
}
