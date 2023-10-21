package edu.hw1;

public class Task4 {
    private Task4() {
    }

    public static String fixString(String input) {
        char[] result = input.toCharArray();

        for (int i = 0; i + 1 < result.length; i += 2) {
            swap(result, i, i + 1);
        }

        return new String(result);
    }

    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
