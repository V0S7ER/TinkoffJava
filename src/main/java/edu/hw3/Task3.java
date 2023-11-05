package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
    private Task3() {
    }

    public static <T> Map<T, Integer> freqDict(List<T> list) {
        Map<T, Integer> result = new HashMap<>();

        if (list == null) {
            return result;
        }

        for (var el : list) {
            result.merge(el, 1, Integer::sum);
        }

        return result;
    }
}
