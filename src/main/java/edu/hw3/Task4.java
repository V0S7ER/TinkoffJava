package edu.hw3;

public class Task4 {
    private Task4() {
    }

    private static final String[] ROMAN_DIGITS =
        {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] ROMAN_VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static String convertToRoman(int inputNumber) {
        int n = inputNumber;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ROMAN_DIGITS.length; ++i) {
            while (n >= ROMAN_VALUES[i]) {
                n -= ROMAN_VALUES[i];
                result.append(ROMAN_DIGITS[i]);
            }
        }

        return result.toString();
    }
}
