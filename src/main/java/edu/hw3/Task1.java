package edu.hw3;

public class Task1 {
    private Task1() {
    }

    public static String atbash(String s) {
        if (s == null) {
            return null;
        }

        char[] result = s.toCharArray();
        for (int i = 0; i < result.length; ++i) {
            result[i] = atbashChar(result[i]);
        }

        return new String(result);
    }

    private static char atbashChar(char c) {
        if ('a' <= c && c <= 'z') {
            return (char) ('z' - (c - 'a'));
        } else if ('A' <= c && c <= 'Z') {
            return (char) ('Z' - (c - 'A'));
        } else {
            return c;
        }
    }
}
