package edu.hw1;

import java.util.Arrays;

public class Task1 {
    private static final int INCORRECT_CODE = -1;
    private static final int MIN_SECONDS = 0;
    private static final int SECONDS_IN_MINUTE = 60;

    private Task1() {
    }

    public static int minutesToSeconds(String time) {
        int[] data;

        try {
            data = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException e) {
            return INCORRECT_CODE;
        }

        if (data.length != 2) {
            return INCORRECT_CODE;
        }

        int minutes = data[0];
        int seconds = data[1];

        if (seconds < MIN_SECONDS || seconds >= SECONDS_IN_MINUTE || minutes < 0) {
            return INCORRECT_CODE;
        }

        return minutes * SECONDS_IN_MINUTE + seconds;
    }
}
