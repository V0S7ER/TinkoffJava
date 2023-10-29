package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    @DisplayName("string \"hello world\" test")
    public void testHelloWorld() {
        String input = "Hello world!";
        String expected = "Svool dliow!";

        assertThat(Task1.atbash(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("Long string test")
    public void testLongString() {
        String input =
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";
        String expected =
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";

        assertThat(Task1.atbash(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource()
    public void testNullAndEmpty(String s) {
        String result = Task1.atbash(s);
        assertThat(result == null || s.equals(result)).isTrue();
    }
}
