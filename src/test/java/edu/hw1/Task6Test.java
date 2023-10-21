package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task6Test {
    @Test
    @DisplayName("3524")
    public void testCount1() {
        int input = 3524;
        int expect = 3;

        Assertions.assertThat(Task6.countK(input)).isEqualTo(expect);
    }

    @Test
    @DisplayName("6621")
    public void testCount2() {
        int input = 6621;
        int expect = 5;

        Assertions.assertThat(Task6.countK(input)).isEqualTo(expect);
    }

    @Test
    @DisplayName("6554")
    public void testCount3() {
        int input = 6554;
        int expect = 4;

        Assertions.assertThat(Task6.countK(input)).isEqualTo(expect);
    }

    @Test
    @DisplayName("1234")
    public void testCount4() {
        int input = 1234;
        int expect = 3;

        Assertions.assertThat(Task6.countK(input)).isEqualTo(expect);
    }

    @Test
    @DisplayName("6174")
    public void testCount5() {
        int input = 6174;
        int expect = 0;

        Assertions.assertThat(Task6.countK(input)).isEqualTo(expect);
    }
}
