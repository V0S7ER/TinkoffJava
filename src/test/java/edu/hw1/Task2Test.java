package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task2Test {

    @Test
    @DisplayName("4666")
    public void countDigits4() {
        Assertions.assertThat(Task2.countDigits(4666)).isEqualTo(4);
    }

    @Test
    @DisplayName("544")
    public void countDigits3() {
        Assertions.assertThat(Task2.countDigits(544)).isEqualTo(3);
    }

    @Test
    @DisplayName("23")
    public void countDigits2() {
        Assertions.assertThat(Task2.countDigits(23)).isEqualTo(2);
    }

    @Test
    @DisplayName("9")
    public void countDigits1() {
        Assertions.assertThat(Task2.countDigits(9)).isEqualTo(1);
    }

    @Test
    @DisplayName("0")
    public void countDigitsZero() {
        Assertions.assertThat(Task2.countDigits(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("-64573")
    public void countDigitsNegative() {
        Assertions.assertThat(Task2.countDigits(-64573)).isEqualTo(5);
    }
}
