package edu.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {

    private static final int TEN = 10;

    private Utils() {
    }

    public static boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    public static boolean isNumber(String s) {
        for (char c : s.toCharArray()) {
            if (!isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    public static List<Integer> getDigits(int numberInput) {
        int number = numberInput;
        List<Integer> digits = new ArrayList<>();

        while (number > 0) {
            digits.add(number % TEN);
            number /= TEN;
        }

        Collections.reverse(digits);
        return digits;
    }
}
