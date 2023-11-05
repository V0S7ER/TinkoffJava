package edu.project1;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public record SingleWordDictionary(String word) implements Dictionary {

    @Override
    public @NotNull String getWord() {
        return word;
    }
}
