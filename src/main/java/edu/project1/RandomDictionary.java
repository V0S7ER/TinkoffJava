package edu.project1;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class RandomDictionary implements Dictionary {
    private static final String[] WORDS = {"hello", "easy", "project"};
    private static final Random RANDOM = new Random();

    @Override
    public @NotNull String getWord() {
        return WORDS[RANDOM.nextInt(WORDS.length)];
    }
}
