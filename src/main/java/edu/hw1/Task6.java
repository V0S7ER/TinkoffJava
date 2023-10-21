package edu.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task6 {
    private Task6() {
    }

    private static final int KAPREKAR_CONSTANT = 6174;
    private static final int MIN_BORDER = 1000;
    private static final int MAX_BORDER = 9999;
    private static final int TEN = 10;
    private static final int RECURSION_LIMIT = 7;
    private static final String INCORRECT_INPUT_MESSAGE = "Incorrect input";

    public static int countK(int number) {
        return countK(number, 0);
    }

    private static int countK(int number, int recursionDepth) {
        if (recursionDepth > RECURSION_LIMIT) {
            throw new RuntimeException(INCORRECT_INPUT_MESSAGE);
        }

        if (number < MIN_BORDER) {
            throw new RuntimeException(INCORRECT_INPUT_MESSAGE);
        }

        if (number > MAX_BORDER) {
            throw new RuntimeException(INCORRECT_INPUT_MESSAGE);
        }

        if (number == KAPREKAR_CONSTANT) {
            return 0;
        }

        var digits = Utils.getDigits(number);

        var digitsSmall = new ArrayList<>(digits);
        Collections.sort(digitsSmall);

        var digitsBig = new ArrayList<>(digitsSmall);
        Collections.reverse(digitsBig);

        int numberBig = getNumber(digitsBig);
        int numberSmall = getNumber(digitsSmall);

        return 1 + countK(numberBig - numberSmall, recursionDepth + 1);
    }

    private static int getNumber(List<Integer> digits) {
        int result = 0;
        for (int digit : digits) {
            result *= TEN;
            result += digit;
        }
        return result;
    }
}
