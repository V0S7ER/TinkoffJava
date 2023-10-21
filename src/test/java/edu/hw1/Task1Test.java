package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class Task1Test {
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int INCORRECT_CODE = -1;


    @Test
    @DisplayName("Проверка правильного перевода корректного времени")
    public void checkCorrectTimes() {
        List<Integer> excepted = new ArrayList<>();
        List<Integer> was = new ArrayList<>();

        final int maxMinutes = 100;

        for (int minutes = 0; minutes <= maxMinutes; ++minutes) {
            for (int seconds = 0; seconds < SECONDS_IN_MINUTE; ++seconds) {
                excepted.add(minutes * SECONDS_IN_MINUTE + seconds);

                was.add(Task1.minutesToSeconds(convertTimeToString(minutes, seconds)));
            }
        }

        Assertions.assertThat(was).isEqualTo(excepted);
    }

    @Test
    @DisplayName("Отрицательные минуты и некорректные секунды")
    public void checkIncorrectTimes() {
        List<Integer> was = new ArrayList<>();

        for (int minutes = -100; minutes < 100; ++minutes) {
            for (int seconds = -100; seconds < 0; ++seconds) {
                was.add(Task1.minutesToSeconds(convertTimeToString(minutes, seconds)));
            }

            for (int seconds = SECONDS_IN_MINUTE; seconds < 100; ++seconds) {
                was.add(Task1.minutesToSeconds(convertTimeToString(minutes, seconds)));
            }

            if (minutes < 0) {
                for (int seconds = 0; seconds < SECONDS_IN_MINUTE; ++seconds) {
                    was.add(Task1.minutesToSeconds(convertTimeToString(minutes, seconds)));
                }
            }
        }

        Assertions.assertThat(was).containsOnly(INCORRECT_CODE);
    }

    @Test
    @DisplayName("Пустая строка")
    public void emptyString() {
        Assertions.assertThat(Task1.minutesToSeconds("")).isEqualTo(INCORRECT_CODE);
    }

    @Test
    @DisplayName("Некорректный формат времени")
    public void incorrectFormat() {
        List<Integer> was = new ArrayList<>();

        was.add(Task1.minutesToSeconds("18:30:40"));
        was.add(Task1.minutesToSeconds("18;30"));

        Assertions.assertThat(was).containsOnly(INCORRECT_CODE);
    }

    private String convertTimeToString(int minutes, int seconds) {
        return String.format("%d:%d", minutes, seconds);
    }
}
