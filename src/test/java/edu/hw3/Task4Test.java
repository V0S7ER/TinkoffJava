package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Convert 2")
    public void test1() {
        int input = 2;
        String exp = "II";

        assertThat(Task4.convertToRoman(input)).isEqualTo(exp);
    }

    @Test
    @DisplayName("Convert 12")
    public void test2() {
        int input = 12;
        String exp = "XII";

        assertThat(Task4.convertToRoman(input)).isEqualTo(exp);
    }
    @Test
    @DisplayName("Convert 499")
    public void test3() {
        int input = 499;
        String exp = "CDXCIX";

        assertThat(Task4.convertToRoman(input)).isEqualTo(exp);
    }
}
