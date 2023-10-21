package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task5Test {
    @Test
    @DisplayName("11211230")
    public void testPalindromeDescendant1() {
        int input = 11211230;

        Assertions.assertThat(Task5.isPalindromeDescendant(input)).isTrue();
    }

    @Test
    @DisplayName("13001120")
    public void testPalindromeDescendant2() {
        int input = 13001120;

        Assertions.assertThat(Task5.isPalindromeDescendant(input)).isTrue();
    }

    @Test
    @DisplayName("23336014")
    public void testPalindromeDescendant3() {
        int input = 23336014;

        Assertions.assertThat(Task5.isPalindromeDescendant(input)).isTrue();
    }

    @Test
    @DisplayName("11")
    public void testPalindromeDescendant4() {
        int input = 11;

        Assertions.assertThat(Task5.isPalindromeDescendant(input)).isTrue();
    }

    @Test
    @DisplayName("991")
    public void testPalindromeDescendant5() {
        int input = 991;
        // 991 -> 181

        Assertions.assertThat(Task5.isPalindromeDescendant(input)).isTrue();
    }
}
