package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Test can put null")
    public void testPutNull() {
        TreeMap<String, String> tree = new TreeMap<>(Task7.getStringComparator());
        tree.put(null, "test");

        assertThat(tree.containsKey(null)).isTrue();
    }
}
