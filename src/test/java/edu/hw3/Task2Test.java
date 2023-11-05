package edu.hw3;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    @DisplayName("()()()")
    public void test1() {
        String input = "()()()";
        List<String> expected = List.of("()", "()", "()");

        assertThat(Task2.clusterize(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("((()))")
    public void test2() {
        String input = "((()))";
        List<String> expected = List.of("((()))");

        assertThat(Task2.clusterize(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("((()))(())()()(()())")
    public void test3() {
        String input = "((()))(())()()(()())";
        List<String> expected = List.of("((()))", "(())", "()", "()", "(()())");

        assertThat(Task2.clusterize(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("((())())(()(()()))")
    public void test4() {
        String input = "((())())(()(()()))";
        List<String> expected = List.of("((())())", "(()(()()))");

        assertThat(Task2.clusterize(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testNullAndEmpty(String s) {
        assertThat(Task2.clusterize(s)).isEmpty();
    }
}
