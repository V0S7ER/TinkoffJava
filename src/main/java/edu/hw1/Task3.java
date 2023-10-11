package edu.hw1;

import java.util.Arrays;

public class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] a1, int[] a2) {
        if (a1.length == 0 || a2.length == 0) {
            return false;
        }

        int min1 = Arrays.stream(a1).min().getAsInt();
        int max1 = Arrays.stream(a1).max().getAsInt();

        int min2 = Arrays.stream(a2).min().getAsInt();
        int max2 = Arrays.stream(a2).max().getAsInt();

        return min1 > min2 && max1 < max2;
    }
}
