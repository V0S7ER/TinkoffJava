package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task7Test {
    @Test
    @DisplayName("rotate right 8 by 1")
    public void testRotateRight1() {
        int number = 8;
        int shift = 1;
        int expected = 4;

        Assertions.assertThat(Task7.rotateRight(number, shift)).isEqualTo(expected);
    }

    @Test
    @DisplayName("rotate left 16 by 1")
    public void testRotateLeft1() {
        int number = 16;
        int shift = 1;
        int expected = 1;

        Assertions.assertThat(Task7.rotateLeft(number, shift)).isEqualTo(expected);
    }

    @Test
    @DisplayName("rotate left 17 by 2")
    public void testRotateLeft2() {
        int number = 17;
        int shift = 2;
        int expected = 6;

        Assertions.assertThat(Task7.rotateLeft(number, shift)).isEqualTo(expected);
    }

    @Test
    @DisplayName("rotate left 30 by 4")
    public void testRotateRight2() {
        int number = 30;
        int shift = 6;
        int expected = 15;

        Assertions.assertThat(Task7.rotateRight(number, shift)).isEqualTo(expected);
    }
}
