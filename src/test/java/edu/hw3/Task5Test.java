package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @Test
    @DisplayName("[ \"John Locke\", \"Thomas Aquinas\", \"David Hume\", \"Rene Descartes\" ], \"ASC\"")
    public void test1() {
        List<String> names = List.of("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes");
        List<String> exp = List.of("Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke");
        assertThat(Task5.parseContacts(names, "ASC")).isEqualTo(exp);
    }

    @Test
    @DisplayName("[\"Paul Erdos\", \"Leonhard Euler\", \"Carl Gauss\"], \"DESC\"")
    public void test2() {
        List<String> names = List.of("Paul Erdos", "Leonhard Euler", "Carl Gauss");
        List<String> exp = List.of("Carl Gauss", "Leonhard Euler", "Paul Erdos");
        assertThat(Task5.parseContacts(names, "DESC")).isEqualTo(exp);
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testNullAndEmpty(List<String> names) {
        assertThat(Task5.parseContacts(names, "abracadabra")).isEmpty();
    }
}
