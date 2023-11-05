package edu.hw3;

public class Task1 {
    private Task1() {
    }

    private static final char LOWER_A = 'a';
    private static final char LOWER_Z = 'z';
    private static final char UPPER_A = 'A';
    private static final char UPPER_Z = 'Z';

    public static String encryptViaAtbash(String s) {
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
        if (LOWER_A <= c && c <= LOWER_Z) {
            return (char) (LOWER_Z - (c - LOWER_A));
        } else if (UPPER_A <= c && c <= UPPER_Z) {
            return (char) (UPPER_Z - (c - UPPER_A));
        } else {
            return c;
        }
    }
}
