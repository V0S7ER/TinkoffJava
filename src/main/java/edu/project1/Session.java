package edu.project1;

import org.jetbrains.annotations.NotNull;

public class Session {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;
    private int guessCount;

    public Session(String answer, int maxAttempts) {
        assert answer != null && !answer.isEmpty();
        this.answer = answer;
        this.userAnswer = "*".repeat(answer.length()).toCharArray();
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
        this.guessCount = 0;
    }

    @NotNull GuessResult guess(String guess) {
        if (guess.length() != 1) {
            return new GuessResult.IncorrectGuess(userAnswer, attempts, maxAttempts);
        }

        char guessLetter = guess.charAt(0);

        boolean wasGuess = false;

        for (int i = 0; i < answer.length(); ++i) {
            if (userAnswer[i] == '*' && answer.charAt(i) == guessLetter) {
                ++guessCount;
                userAnswer[i] = guessLetter;
                wasGuess = true;
            }
        }

        if (!wasGuess) {
            attempts++;
        }

        if (guessCount == answer.length()) {
            return new GuessResult.Win(userAnswer, attempts, maxAttempts);
        }

        if (attempts == maxAttempts) {
            return new GuessResult.Defeat(userAnswer, attempts, maxAttempts);
        }

        return terminalGuess(wasGuess);
    }

    /**
     * function to fix limit on <= 4 returns in one function in mvn::checkstyle
     **/
    private @NotNull GuessResult terminalGuess(boolean wasGuess) {
        if (wasGuess) {
            return new GuessResult.SuccessGuess(userAnswer, attempts, maxAttempts);
        } else {
            return new GuessResult.FailedGuess(userAnswer, attempts, maxAttempts);
        }
    }

    @NotNull GuessResult giveUp() {
        return new GuessResult.Defeat(userAnswer, attempts, maxAttempts);
    }
}
