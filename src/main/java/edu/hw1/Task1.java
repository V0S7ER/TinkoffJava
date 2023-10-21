package edu.hw1;

public class Task1 {
    private static final int INCORRECT_CODE = -1;
    private static final int MIN_SECONDS = 0;
    private static final int SECONDS_IN_MINUTE = 60;

    private Task1() {
    }

    public static int minutesToSeconds(String time) {
        String[] data;
        data = time.split(":");

        if (data.length != 2) {
            return INCORRECT_CODE;
        }

        if (!Utils.isNumber(data[0]) || !Utils.isNumber(data[1])) {
            return INCORRECT_CODE;
        }

        int minutes = Integer.parseInt(data[0]);
        int seconds = Integer.parseInt(data[1]);

        if (seconds < MIN_SECONDS || seconds >= SECONDS_IN_MINUTE || minutes < 0) {
            return INCORRECT_CODE;
        }

        return minutes * SECONDS_IN_MINUTE + seconds;
    }
}
