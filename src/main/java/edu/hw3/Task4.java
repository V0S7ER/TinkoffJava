package edu.hw3;

public class Task4 {
    private Task4() {
    }

    public static String convertToRoman(int inputNumber) {
        int n = inputNumber;
        final String[] romanDigits = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        final int[] romanValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < romanDigits.length; ++i) {
            while (n >= romanValues[i]) {
                n -= romanValues[i];
                result.append(romanDigits[i]);
            }
        }

        return result.toString();
    }
}
