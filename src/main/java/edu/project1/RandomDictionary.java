package edu.project1;

import org.jetbrains.annotations.NotNull;

public class DefaultDictionary implements Dictionary {
    private static final String[] words = {"hello", "easy", "project"};
    private static int counter = 0;

    @Override
    public @NotNull String getWord() {
        if (counter == words.length) {
            counter = 0;
        }

        return words[counter++];
    }
}
