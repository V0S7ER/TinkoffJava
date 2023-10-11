package edu.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task5 {
    private Task5() {
    }

    private static final int TEN = 10;

    public static boolean isPalindromeDescendant(int number) {
        var digits = getDigits(number);

        if (digits.size() == 1) {
            return false;
        }

        if (isPalindrome(digits)) {
            return true;
        }

        int nextNumber = getNextNumber(digits);
        return isPalindromeDescendant(nextNumber);
    }

    private static int getNextNumber(List<Integer> digits) {
        List<Integer> nextDigits = new ArrayList<>();
        for (int i = 0; i < digits.size(); i += 2) {
            if (i == digits.size() - 1) {
                nextDigits.add(digits.get(i));
            } else {
                int val = digits.get(i) + digits.get(i + 1);
                if (val >= TEN) {
                    nextDigits.add(val / TEN);
                    nextDigits.add(val % TEN);
                } else {
                    nextDigits.add(val);
                }
            }
        }

        int nextNumber = 0;
        for (int digit : nextDigits) {
            nextNumber *= TEN;
            nextNumber += digit;
        }

        return nextNumber;
    }

    private static boolean isPalindrome(List<Integer> digits) {
        for (int left = 0, right = digits.size() - 1; left < right; ++left, --right) {
            if (!digits.get(left).equals(digits.get(right))) {
                return false;
            }
        }

        return true;
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
}
