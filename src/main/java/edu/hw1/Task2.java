package edu.hw1;

public class Task2 {
    private Task2() {
    }

    private static final int TEN = 10;

    public static int countDigits(int numberInput) {
        int number = Math.abs(numberInput);

        if (number == 0) {
            return 1;
        }

        int result = 0;
        while (number > 0) {
            number /= TEN;
            result++;
        }

        return result;
    }
}
