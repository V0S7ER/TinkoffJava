package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    @DisplayName("[\"a\", \"bb\", \"a\", \"bb\"]")
    public void test1() {
        List<?> input = List.of("a", "bb", "a", "bb");
        Map exp = new HashMap<>();

        exp.put("a", 2);
        exp.put("bb", 2);

        assertThat(Task3.freqDict(input)).isEqualTo(exp);
    }

    @Test
    @DisplayName("[\"this\", \"and\", \"that\", \"and\"]")
    public void test2() {
        List<?> input = List.of("this", "and", "that", "and");
        Map exp = new HashMap<>();

        exp.put("that", 1);
        exp.put("and", 2);
        exp.put("this", 1);

        assertThat(Task3.freqDict(input)).isEqualTo(exp);
    }

    @Test
    @DisplayName("[\"код\", \"код\", \"код\", \"bug\"]")
    public void test3() {
        List<?> input = List.of("код", "код", "код", "bug");
        Map exp = new HashMap<>();

        exp.put("код", 3);
        exp.put("bug", 1);

        assertThat(Task3.freqDict(input)).isEqualTo(exp);
    }

    @Test
    @DisplayName("[1, 1, 2, 2]")
    public void test4() {
        List<?> input = List.of(1, 1, 2, 2);
        Map exp = new HashMap<>();

        exp.put(1, 2);
        exp.put(2, 2);

        assertThat(Task3.freqDict(input)).isEqualTo(exp);
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testNullAndEmpty(List<?> input) {
        assertThat(Task3.freqDict(input)).isEmpty();
    }
}
