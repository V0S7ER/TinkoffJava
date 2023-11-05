package edu.hw3;

import edu.hw3.Task8.BackwardIterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8Test {
    @Test
    @DisplayName("Try iterate through [1, 2, 3] reversed")
    public void testFromSample() {
        List<Integer> input = List.of(1, 2, 3);
        BackwardIterator<Integer> iterator = new BackwardIterator<>(input);

        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(3);

        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(2);

        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(1);

        assertThat(iterator.hasNext()).isFalse();
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testNullAndEmpty(List<?> input) {
        BackwardIterator<?> iterator = new BackwardIterator<>(input);
        assertThat(iterator.hasNext()).isFalse();
    }
}
