package io.github.fabasoad.hackerrank;

/**
 * https://www.hackerrank.com/challenges/kaprekar-numbers/problem
 */
public class Solution_KaprekarNumbers {
    public static void main(String[] args) {
        kaprekarNumbers(1, 99999);
    }
    static void kaprekarNumbers(int p, int q) {
        boolean exist = false;
        if (p < 2 && q > 0) {
            exist = true;
            System.out.print("1 ");
        }
        if (p < 10 && q > 8) {
            exist = true;
            System.out.print("9 ");
        }
        for (long i = Math.max(p, 10); i <= Math.max(q, 10); i++) {
            long n = i * i;
            int length = (int) (Math.log10(n) + 1);
            length += length % 2 == 1 ? 1 : 0;
            int s = (int) Math.pow(10.0, (int) length / 2);
            long l = n / s;
            long r = n % s;
            if (r != 0 && l + r == i) {
                exist = true;
                System.out.print(i + " ");
            }
        }
        if (!exist)
            System.out.print("INVALID RANGE");
    }
}
