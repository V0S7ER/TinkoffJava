package edu.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task6 {
    private Task6() {
    }

    private static final int KAPREKAR_CONSTANT = 6174;
    private static final int THOUSAND = 1000;
    private static final int TEN = 10;

    public static int countK(int number) {
        if (number < THOUSAND) {
            throw new RuntimeException("Incorrect input");
        }

        if (number == KAPREKAR_CONSTANT) {
            return 0;
        }

        var digits = getDigits(number);

        var digitsSmall = new ArrayList<>(digits);
        Collections.sort(digitsSmall);

        var digitsBig = new ArrayList<>(digitsSmall);
        Collections.reverse(digitsBig);

        int numberBig = getNumber(digitsBig);
        int numberSmall = getNumber(digitsSmall);

        return 1 + countK(numberBig - numberSmall);
    }

    private static List<Integer> getDigits(int numberInput) {
        int number = numberInput;
        List<Integer> result = new ArrayList<>();

        while (number > 0) {
            result.add(number % TEN);
            number /= TEN;
        }

        Collections.reverse(result);

        return result;
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
