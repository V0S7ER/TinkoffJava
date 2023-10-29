package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private Task2() {
    }

    public static List<String> clusterize(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            } else {
                throw new IllegalArgumentException("String is not PSP");
            }
        }

        if (balance != 0) {
            throw new IllegalArgumentException("String is not PSP");
        }

        List<String> result = new ArrayList<>();
        int last = 0;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                balance++;
            } else {
                --balance;
            }

            if (balance == 0) {
                result.add(s.substring(last, i + 1));
                last = i + 1;
            }
        }

        return result;
    }
}
