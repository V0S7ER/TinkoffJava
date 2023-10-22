package edu.project1;

import org.jetbrains.annotations.NotNull;

public sealed interface GuessResult {
    char[] state();

    int attempt();

    int maxAttempts();

    @NotNull String getMessage();

    record Defeat(char[] state, int attempt, int maxAttempts) implements GuessResult {
        @Override public @NotNull String getMessage() {
            return String.format(
                "The word: %s\nYou lost! (attempts %d out of %d)\n",
                new String(state),
                attempt,
                maxAttempts
            );
        }
    }

    record Win(char[] state, int attempt, int maxAttempts) implements GuessResult {
        @Override public @NotNull String getMessage() {
            return String.format(
                "You won! (attempts %d out of %d).\nThe word was: %s",
                attempt,
                maxAttempts,
                new String(state)
            );
        }
    }

    record SuccessGuess(char[] state, int attempt, int maxAttempts) implements GuessResult {

        @Override public @NotNull String getMessage() {
            return String.format("Hit!\nThe word: %s", new String(state));
        }
    }

    record FailedGuess(char[] state, int attempt, int maxAttempts) implements GuessResult {
        @Override public @NotNull String getMessage() {
            return String.format("Missed, mistake %d out of %d\nThe word: %s", attempt, maxAttempts, new String(state));
        }
    }

    record IncorrectGuess(char[] state, int attempt, int maxAttempts) implements GuessResult {
        @Override public @NotNull String getMessage() {
            return "Incorrect input. Try again!";
        }
    }
}
