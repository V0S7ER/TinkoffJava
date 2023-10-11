package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task4Test {
    @Test
    @DisplayName("\"123456\"")
    public void testFixString1() {
        String input = "123456";
        String expected = "214365";

        Assertions.assertThat(Task4.fixString(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("\"hTsii  s aimex dpus rtni.g\"")
    public void testFixString2() {
        String input = "hTsii  s aimex dpus rtni.g";
        String expected = "This is a mixed up string.";

        Assertions.assertThat(Task4.fixString(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("\"badce\"")
    public void testFixString3() {
        String input = "badce";
        String expected = "abcde";

        Assertions.assertThat(Task4.fixString(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("Empty string")
    public void testFixStringEmpty() {
        String input = "";
        String expected = "";

        Assertions.assertThat(Task4.fixString(input)).isEqualTo(expected);
    }
}
