package io.github.fabasoad.hackerrank.easy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/lisa-workbook/problem
 */
public class Solution_LisasWorkbook {

    public static void main(String[] args) {
        assert 100 == workbook(1, 1, new int[] { 100 });
        assert 4 == workbook(5, 3, new int[] { 4, 2, 6, 1, 10 });
        assert 11 == workbook(15, 20, new int[] { 1, 8, 19, 15, 2, 29, 3, 2, 25, 2, 19, 26, 17, 33, 22 });
        assert 8 == workbook(10, 5, new int[] { 3, 8, 15, 11, 14, 1, 9, 2, 24, 31 });
        assert 11 == workbook(25, 10, new int[] { 1, 29, 94, 15, 87, 100, 20, 55, 100, 45, 82, 80, 100, 100, 3, 53, 100, 2, 100, 100, 100, 100, 100, 100, 1 });
    }

    private static class Problem {
        int num;
        Problem(int n) {
            this.num = n;
        }

        @Override
        public String toString() {
            return "Problem#" + num;
        }
    }

    private static class Page extends ArrayList<Problem> {
        int num;
        Page(int n) {
            this.num = n;
        }
        void addProblems(int s, int e) {
            IntStream.range(s, e).mapToObj(Problem::new).forEach(this::add);
        }
        @Override
        public String toString() {
            return "Page#" + num;
        }
        boolean isSpecial() {
            return this.stream().anyMatch(p -> p.num == this.num);
        }
    }

    private static class Chapter extends ArrayList<Page> {
        int num;
        Chapter(int n) {
            this.num = n;
        }
        void addPage(int num, int s, int e) {
            final Page page = new Page(num);
            page.addProblems(s, e);
            this.add(page);
        }
        @Override
        public String toString() {
            return "Chapter#" + num;
        }
        public int getSpecialCount() {
            return (int) this.stream().filter(Page::isSpecial).count();
        }
    }

    private static class Chapters extends ArrayList<Chapter> {
        public int getSpecialCount() {
            return this.stream().map(Chapter::getSpecialCount).reduce(Integer::sum).orElse(0);
        }
        public int getPagesCount() {
            return (int) stream().mapToLong(Collection::size).sum();
        }
    }

    static int workbook(int n, int k, int[] arr) {
        final Chapters chapters = new Chapters();
        for (int i = 0; i < n; i++) {
            final Chapter chapter = new Chapter(chapters.size() + 1);
            if (k < arr[i]) {
                int last = arr[i] % k;
                int pages = (arr[i] - last) / k + (last > 0 ? 1 : 0);
                for (int p = 1; p <= (pages * k); p += k) {
                    int delta = p + k > pages * k ? (last == 0 ? (pages * k - p) : last) : k;
                    delta = p == pages * k && delta == 0 ? 1 : delta;
                    chapter.addPage(chapters.getPagesCount() + chapter.size() + 1, p, p + delta);
                }
            } else {
                chapter.addPage(chapters.getPagesCount() + chapter.size() + 1, 1, arr[i] + 1);
            }
            chapters.add(chapter);
        }
        return chapters.getSpecialCount();
    }
}
