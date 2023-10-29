package edu.hw3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task5 {
    private Task5() {
    }

    public static List<String> parseContacts(List<String> inputData, String arg) {
        if (arg == null || inputData == null || inputData.isEmpty() || arg.isEmpty()) {
            return new ArrayList<>();
        }

        var names = new ArrayList<>(inputData);

        Comparator<String> naturalOrderComparator = (o1, o2) -> {
            String[] data1 = o1.split("\\s+");
            String[] data2 = o2.split("\\s+");
            if (data1.length > 2 || data2.length > 2 || data1.length == 0 || data2.length == 0) {
                throw new IllegalArgumentException("Illegal name!");
            }
            if (data1.length == 1 || data2.length == 1) {
                return data1[0].compareTo(data2[0]);
            } else {
                return data1[data1.length - 1].compareTo(data2[data2.length - 1]);
            }
        };

        Comparator<String> comparator = switch (arg) {
            case "ASC" -> naturalOrderComparator;
            case "DESC" -> naturalOrderComparator.reversed();
            case null, default -> throw new IllegalArgumentException("Illegal comparator arg!");
        };

        names.sort(comparator);
        return names;
    }
}
