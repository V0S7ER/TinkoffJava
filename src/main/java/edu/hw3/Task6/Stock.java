package edu.hw3.Task6;

import org.jetbrains.annotations.NotNull;

public record Stock(int value, String name) implements Comparable<Stock> {
    @Override
    public int compareTo(@NotNull Stock o) {
        if (value == o.value) {
            return name.compareTo(o.name);
        }
        return Integer.compare(o.value, value);
    }
}
