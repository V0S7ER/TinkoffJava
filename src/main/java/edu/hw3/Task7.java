package edu.hw3;

import java.util.Comparator;

public class Task7 {
    private Task7() {
    }

    public static Comparator<String> getStringComparator() {
        return (o1, o2) -> {
            if (o1 == null && o2 == null) {
                return 0;
            }

            if (o1 == null) {
                return -1;
            }

            if (o2 == null) {
                return 1;
            }

            return o1.compareTo(o2);
        };
    }
}
