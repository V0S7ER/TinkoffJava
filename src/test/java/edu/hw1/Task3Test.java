package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task3Test {
    @Test
    @DisplayName("[1, 2, 3, 4], [0, 6]")
    public void testNestable1() {
        int[] a1 = new int[]{1, 2, 3, 4};
        int[] a2 = new int[]{0, 6};

        Assertions.assertThat(Task3.isNestable(a1, a2)).isTrue();
    }

    @Test
    @DisplayName("[3, 1], [4, 0]")
    void testNestable2() {
        int[] a1 = new int[]{3, 1};
        int[] a2 = new int[]{4, 0};

        Assertions.assertThat(Task3.isNestable(a1, a2)).isTrue();
    }

    @Test
    @DisplayName("[9, 9, 8], [8, 9]")
    void testNestable3() {
        int[] a1 = new int[]{9, 9, 8};
        int[] a2 = new int[]{8, 9};

        Assertions.assertThat(Task3.isNestable(a1, a2)).isFalse();
    }

    @Test
    @DisplayName("[1, 2, 3, 4], [2, 3]")
    void testNestable4() {
        int[] a1 = new int[]{1, 2, 3, 4};
        int[] a2 = new int[]{2, 3};

        Assertions.assertThat(Task3.isNestable(a1, a2)).isFalse();
    }

    @Test
    @DisplayName("[], [1, 2]")
    void testNestableEmptyArray1() {
        int[] a1 = new int[]{};
        int[] a2 = new int[]{1, 2};

        Assertions.assertThat(Task3.isNestable(a1, a2)).isFalse();
    }

    @Test
    @DisplayName("[1, 2], []")
    void testNestableEmptyArray2() {
        int[] a1 = new int[]{1, 2};
        int[] a2 = new int[]{};
        Assertions.assertThat(Task3.isNestable(a1, a2)).isFalse();
    }

    @Test
    @DisplayName("[], []")
    public void testNestableEmptyArray3() {
        int[] a1 = new int[]{};
        int[] a2 = new int[]{};

        Assertions.assertThat(Task3.isNestable(a1, a2)).isFalse();
    }
}
