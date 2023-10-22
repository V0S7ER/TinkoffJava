package edu.project1;

import org.jetbrains.annotations.NotNull;

public class SingleWordDictionary implements Dictionary {

    private final String word;

    public SingleWordDictionary(String word) {
        this.word = word;
    }

    @Override
    public @NotNull String getWord() {
        return word;
    }
}
